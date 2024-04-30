package com.example.pranksounds.ui.activities

import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.pranksounds.R
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.databinding.ActivityPlaySoundBinding
import com.example.pranksounds.utils.Constants
import com.example.pranksounds.utils.GoogleMobileAdsConsentManager
import com.example.pranksounds.viewModels.PlaySoundViewModel
import com.google.ads.mediation.admob.AdMobAdapter
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.nativead.NativeAd
import com.startapp.sdk.ads.banner.Banner
import com.startapp.sdk.adsbase.StartAppAd
import java.io.IOException
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.random.Random


class PlaySoundActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaySoundBinding
    private lateinit var mediaPlayer: MediaPlayer
    private val handler = Handler(Looper.getMainLooper())

    private lateinit var playSoundViewModel: PlaySoundViewModel
    private var soundItem: SoundItem? = null
    private var isMarkedFav = false

    private val isMobileAdsInitializeCalled = AtomicBoolean(false)
    private lateinit var googleMobileAdsConsentManager: GoogleMobileAdsConsentManager
    private var currentNativeAd: NativeAd? = null

    // Scale the image to 1.5 times its size in both x and y direction
    private lateinit var scaleX: ObjectAnimator
    private lateinit var scaleY: ObjectAnimator
    private lateinit var shake: ObjectAnimator


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

        binding = ActivityPlaySoundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playSoundViewModel =
            ViewModelProvider(this)[PlaySoundViewModel::class.java]

        binding.soundItem = getSoundItem()
        binding.lifecycleOwner = this

        setupViews()
        setupDelaySpinner()
        setupMediaPlayer()
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

    fun onIvBackClick(view: View) {
        finish()
    }

    private fun setupViews() {
        setupNativeAd()

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

        binding.ibPlaySound.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                startMediaPlayer()
            }, getDelayTime())
        }

        binding.ivPlaySoundIcon.setOnClickListener {
            binding.ibPlaySound.performClick()
        }

        binding.ivLoop.setOnClickListener {
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

            startAnimation()
            updateSeekBar()
        }
    }

    private fun startAnimation() {
        scaleX = ObjectAnimator.ofFloat(binding.ivPlaySoundIcon, "scaleX", 1f, 1.5f)
        scaleY = ObjectAnimator.ofFloat(binding.ivPlaySoundIcon, "scaleY", 1f, 1.5f)
        shake = ObjectAnimator.ofFloat(
            binding.ivPlaySoundIcon,
            "translationX",
            0f,
            10f,
            -10f,
            10f,
            -10f,
            0f
        )

        scaleX.duration = 100
        scaleY.duration = 100
        shake.duration = 100 // Control the speed of shaking

        scaleX.repeatCount = ObjectAnimator.INFINITE
        scaleY.repeatCount = ObjectAnimator.INFINITE

        scaleX.repeatMode = ObjectAnimator.REVERSE
        scaleY.repeatMode = ObjectAnimator.REVERSE

        shake.repeatCount = ObjectAnimator.INFINITE
        shake.repeatMode = ObjectAnimator.REVERSE

        scaleX.start()
        scaleY.start()
        shake.start()
    }

    private fun stopAnimation() {
        scaleX.cancel()
        scaleY.cancel()
        shake.cancel()
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
                    stopAnimation()
                }
            }
        })
    }

    private fun setupNativeAd() {
        googleMobileAdsConsentManager =
            GoogleMobileAdsConsentManager.getInstance(applicationContext)
        googleMobileAdsConsentManager.gatherConsent(this) { consentError ->
            if (consentError != null) {
                // Consent not obtained in current session.
                Log.w("PlaySoundActivity", "${consentError.errorCode}. ${consentError.message}")
            }
        }

        // This sample attempts to load ads using consent obtained in the previous session.
        if (googleMobileAdsConsentManager.canRequestAds) {
            if (isMobileAdsInitializeCalled.getAndSet(true)) {
                return
            }
            loadBannerAd()
        }
    }

    private fun loadStartappBannerAd() {
        val banner = Banner(this)
        binding.bannerAdPlaceholder.addView(banner)
    }

    private fun loadInterstitialAd() {
        val adRequest: AdRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    val error =
                        "domain: ${adError.domain}, code: ${adError.code}, " + "message: ${adError.message}"

                    StartAppAd.showAd(this@PlaySoundActivity)
                }

                override fun onAdLoaded(ad: InterstitialAd) {

                    ad.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {

                            }

                            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                StartAppAd.showAd(this@PlaySoundActivity)
                            }

                            override fun onAdShowedFullScreenContent() {

                            }
                        }

                    ad.show(this@PlaySoundActivity)
                }
            }
        )
    }

    private fun loadBannerAd() {
        val adView = AdView(this)
        binding.bannerAdPlaceholder.addView(adView)
        // This is an ad unit ID for a test ad. Replace with your own banner ad unit ID.
        adView.adUnitId = "ca-app-pub-3940256099942544/9214589741"
        adView.setAdSize(bannerAdSize)


        if (Random.nextInt(1, 3) == 2) { // only 1 or 2 will be generated
            val extras = Bundle()
            extras.putString("collapsible", "bottom")

            val adRequest = AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter::class.java, extras)
                .build()

            // Start loading the ad in the background.
            adView.loadAd(adRequest)
        } else {
            val adRequest = AdRequest.Builder().build()
            adView.loadAd(adRequest)
        }

        adView.adListener = object : AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                loadStartappBannerAd()
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        }
    }

    override fun onDestroy() {
        if (Constants.USER_INTERACTIONS_COUNT >= 3) {
            Constants.USER_INTERACTIONS_COUNT = 0
            loadInterstitialAd()
        }

        currentNativeAd?.destroy()
        super.onDestroy()
        mediaPlayer.release()
        handler.removeCallbacksAndMessages(null) // Stop the Handler when the activity is being destroyed
    }
}