package com.example.pranksounds.ui.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pranksounds.data.models.SoundCategoryItem
import com.example.pranksounds.databinding.ActivitySoundsListBinding
import com.example.pranksounds.ui.adapters.SoundClickListener
import com.example.pranksounds.ui.adapters.SoundsListAdapter
import com.example.pranksounds.utils.Constants
import com.example.pranksounds.ui.viewModels.SoundsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SoundsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoundsListBinding
    private lateinit var soundsListAdapter: SoundsListAdapter
    private val soundsListViewModel: SoundsListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializations()
        setupAdapterOnSoundsList()
    }

    private fun initializations() {
        binding = ActivitySoundsListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val soundCategory = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.SELECTED_CATEGORY, SoundCategoryItem::class.java)
        } else {
            intent.getParcelableExtra<SoundCategoryItem>(Constants.SELECTED_CATEGORY)
        }

        binding.soundCategoryItem = soundCategory
        binding.lifecycleOwner = this
    }

    fun onIvBackClick(view: View) {
        finish()
    }

    private fun setupAdapterOnSoundsList() {

        val categoryId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.SELECTED_CATEGORY, SoundCategoryItem::class.java)?.categoryId?: -1
        } else {
            intent.getParcelableExtra<SoundCategoryItem>(Constants.SELECTED_CATEGORY)?.categoryId?: -1
        }

        soundsListAdapter = SoundsListAdapter(soundsListViewModel.getSoundsList(this, categoryId), SoundClickListener {
            val intent = Intent(this, PlaySoundActivity::class.java)
            intent.putExtra(Constants.SELECTED_SOUND, it)
            startActivity(intent)

            Constants.USER_INTERACTIONS_COUNT++
        })

        binding.rvSoundsList.adapter = soundsListAdapter
    }
}