package com.example.pranksounds.ui.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.pranksounds.R
import com.example.pranksounds.databinding.ActivityPlaySoundBinding
import com.example.pranksounds.databinding.ActivitySettingsBinding
import com.example.pranksounds.utils.Constants
import com.example.pranksounds.utils.LangHelper
import com.example.pranksounds.viewModels.LanguagesListViewModel

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var languagesListViewModel: LanguagesListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        languagesListViewModel =
            ViewModelProvider(this)[LanguagesListViewModel::class.java]

        setValuesOnViews()
    }

    private fun setValuesOnViews() {
        val languagesList = languagesListViewModel.getLanguagesList(this)
        val currentLanCode = LangHelper.getCurrentLocale(this)?.language

        currentLanCode?.let {
            val currentLanguage = languagesList.first { it.languageCode == currentLanCode }
            binding.tvSelectedLanguage.text = currentLanguage.languageName
        } ?: run {
            binding.tvSelectedLanguage.text = getString(R.string.english)
        }
    }

    fun onClLanguageClick(view: View) {
        startActivity(Intent(this, LanguagesListActivity::class.java))
    }

    fun onIvBackClick(view: View) {
        finish()
    }

    fun onTvShareClick(view: View) {
        val playStoreUrl = "https://play.google.com/store/apps/details?id=$packageName"

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT,
                getString(
                    R.string.if_you_want_to_prank_someone_then_check_out_this_app,
                    playStoreUrl
                )
            )
            type = "text/plain"
        }

        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_via)))
    }

    fun onTvRateUsClick(view: View) {
        try {
            // Try to open the Play Store app
            val playStoreIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("market://details?id=$packageName")
            )
            startActivity(playStoreIntent)
        } catch (e: ActivityNotFoundException) {
            // If the Play Store app isn't installed, open in a browser
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
            )
            startActivity(browserIntent)
        }
    }

    fun onTvPrivacyPolicyClick(view: View) {

    }

    fun onTvFeedbackClick(view: View) {
        val feedbackEmail = "platinum.studios.co@gmail.com"
        val subject = getString(R.string._feedback, getString(R.string.app_name))

        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")  // Opening a mail client
            putExtra(Intent.EXTRA_EMAIL, arrayOf(feedbackEmail))  // Default recipient
            putExtra(Intent.EXTRA_SUBJECT, subject)  // Default subject
        }

        try {
            startActivity(emailIntent)
        } catch (e: ActivityNotFoundException) {
            // If no email client is available, you can notify the user
        }
    }
}