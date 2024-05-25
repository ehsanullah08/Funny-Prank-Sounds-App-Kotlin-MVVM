package com.example.pranksounds.ui.activities

import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.pranksounds.R
import com.example.pranksounds.data.source.local.SoundItem
import com.example.pranksounds.databinding.ActivityPlaySoundBinding
import com.example.pranksounds.utils.ads.AdsHelper
import com.example.pranksounds.utils.AnimationHelper
import com.example.pranksounds.utils.Constants
import com.example.pranksounds.ui.viewModels.PlaySoundViewModel
import com.google.android.gms.ads.AdSize
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException


@AndroidEntryPoint
class PlaySoundActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaySoundBinding
    private lateinit var mediaPlayer: MediaPlayer
    private val handler = Handler(Looper.getMainLooper())

    private val playSoundViewModel: PlaySoundViewModel by viewModels()
    private var soundItem: SoundItem? = null
    private var isMarkedFav = false

    private var timerJob: Job? = null


    private val bannerAdSize: AdSize
        get() {
            val display = windowManager.defaultDisplay
            val outMetrics = DisplayMetrics()
            display.getMetrics(outMetrics)

            val density = outMetrics.density

            var adWidthPixels = binding.bannerAdPlaceholder.width.toFloat()
            if (adWidthPixels == 0f) {
                adWidthPixels = outMetrics.widthPixels.toFloat()
            }

            val adWidth = (adWidthPixels / density).toInt()
            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth)
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializations()
        setupViews()
    }

    private fun initializations() {
        binding = ActivityPlaySoundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.soundItem = getSoundItem()
        binding.lifecycleOwner = this
    }

    fun onIvBackClick(view: View) {
        finish()
    }

    fun onIvFavClick(view: View) {

        soundItem?.let {

            if (isMarkedFav) {
                isMarkedFav = false
                binding.ivFavourite.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_fav
                    )
                )
                playSoundViewModel.removeFav(this, soundItem?.soundId!!)
            } else {

                isMarkedFav = true
                binding.ivFavourite.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_fav_filled
                    )
                )
                playSoundViewModel.markFav(this, soundItem!!)
            }
        }
    }

    fun onIbPlaySoundClick(view: View) {
        startMediaPlayer()
    }

    fun onIvPlaySoundIconClick(view: View) {
        binding.ibPlaySound.performClick()
    }

    fun onIvLoopClick(view: View) {
        if (mediaPlayer.isLooping) {
            mediaPlayer.isLooping = false
            binding.tvLoopStatus.text = getString(R.string.loop_off)
            binding.ivLoop.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_start_loop
                )
            )
        } else {
            mediaPlayer.isLooping = true
            binding.tvLoopStatus.text = getString(R.string.loop_on)
            binding.ivLoop.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_stop_loop
                )
            )
        }
    }

    fun onIvCancelTimerClick(view: View) {
        stopCoroutineTimer()
    }

    private fun getSoundItem(): SoundItem? {
        if (intent.hasExtra(Constants.SELECTED_SOUND)) {
            soundItem = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra(Constants.SELECTED_SOUND, SoundItem::class.java)
            } else {
                intent.getParcelableExtra<SoundItem>(Constants.SELECTED_SOUND)
            }
        }

        return soundItem
    }

    private fun setupViews() {
        AdsHelper.loadBannerAdWithConsent(
            this@PlaySoundActivity,
            binding.bannerAdPlaceholder,
            Constants.BANNER_AD_ID_1,
            bannerAdSize
        )

        setupFavorite()
        setupDelaySpinner()
        setupMediaPlayer()
    }

    private fun setupFavorite() {
        soundItem?.let {
            
            playSoundViewModel.isSoundExists(this, soundItem?.soundId!!).observe(this) {
                if (it > 0) {
                    isMarkedFav = true
                    binding.ivFavourite.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.ic_fav_filled
                        )
                    )
                } else {
                    isMarkedFav = false
                    binding.ivFavourite.setImageDrawable(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.ic_fav
                        )
                    )
                }
            }
        }
    }

    private fun setupDelaySpinner() {
        val itemList = listOf(
            getString(R.string.play_instantly),
            getString(R.string.play_after_5s),
            getString(R.string.play_after_10s),
            getString(R.string.play_after_15s),
            getString(R.string.play_after_20s),
            getString(R.string.play_after_30s),
            getString(R.string.play_after_40s),
            getString(R.string.play_after_50s),
            getString(R.string.play_after_60s)
        )
        val adapter = ArrayAdapter(this, R.layout.item_simple_spinner, itemList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter


        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position)
                if (position == 0) {
                    stopCoroutineTimer()
                } else {
                    startCoroutineTimer((getDelayTime() / 1000).toInt())

                    if (mediaPlayer.isPlaying)
                        binding.ibPlaySound.performClick()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle case where no item is selected, if needed
            }
        }
    }

    private fun startCoroutineTimer(countdownTime: Int) {

        // Cancel the previous timer job if it exists
        timerJob?.cancel()

        timerJob = lifecycleScope.launch {
            var currentTime = countdownTime
            binding.timerGroup.visibility = View.VISIBLE

            while (currentTime > 0) {

                binding.tvTimer.text = formatSecondsToMMSS(currentTime)
                delay(1000)

                if (currentTime == 1) {
                    binding.ibPlaySound.performClick()
                }

                currentTime--
            }
        }
    }

    private fun stopCoroutineTimer() {
        timerJob?.cancel()
        binding.spinner.setSelection(0)
        binding.timerGroup.visibility = View.INVISIBLE
    }

    private fun setupMediaPlayer() {
        try {
            mediaPlayer = MediaPlayer()
            val assetFileDescriptor = assets.openFd(soundItem?.fileName ?: "jumper.mp3")
            mediaPlayer.setDataSource(
                assetFileDescriptor.fileDescriptor,
                assetFileDescriptor.startOffset,
                assetFileDescriptor.length
            )
            mediaPlayer.prepare()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun getDelayTime(): Long {
        var delay = 0L
        when (binding.spinner.selectedItemId.toInt()) {
            0 -> delay = 0
            1 -> delay = 5000
            2 -> delay = 10000
            3 -> delay = 15000
            4 -> delay = 20000
            5 -> delay = 30000
            6 -> delay = 40000
            7 -> delay = 50000
            8 -> delay = 60000
        }
        return delay
    }

    private fun startMediaPlayer() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            binding.ibPlaySound.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_play
                )
            )
            binding.ibPlaySound.setBackgroundResource(R.drawable.rounded_orange_button_background)
        } else {
            mediaPlayer.start()
            binding.ibPlaySound.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_pause
                )
            )
            binding.ibPlaySound.setBackgroundResource(R.drawable.rounded_red_button_background)
            stopCoroutineTimer()

            AnimationHelper.startAnimation(
                this,
                binding.ivPlaySoundIcon,
                soundItem?.fileName?.contains("trimmer")!!
            )
            updateSeekBar()
        }
    }

    private fun updateSeekBar() {
        binding.seekbar.max = mediaPlayer.duration
        handler.post(object : Runnable {
            override fun run() {
                if (mediaPlayer.isPlaying) {
                    binding.seekbar.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 100)
                } else {
                    binding.ibPlaySound.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@PlaySoundActivity,
                            R.drawable.ic_play
                        )
                    )

                    binding.ibPlaySound.setBackgroundResource(R.drawable.rounded_orange_button_background)
                    AnimationHelper.stopAnimation()
                }
            }
        })
    }

    private fun stopSoundsAndViews() {
        AnimationHelper.stopVibration()
        stopCoroutineTimer()
        mediaPlayer.release()
        handler.removeCallbacksAndMessages(null) // Stop the Handler when the activity is being destroyed
    }

    private fun formatSecondsToMMSS(seconds: Int): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }

    override fun onDestroy() {
        if (Constants.USER_INTERACTIONS_COUNT >= 3) {
            Constants.USER_INTERACTIONS_COUNT = 0

            AdsHelper.loadInterstitialAdWithConsent(
                this@PlaySoundActivity,
                Constants.INTERSTITIAL_AD_ID_1
            )
        }

        super.onDestroy()
        stopSoundsAndViews()
    }
}