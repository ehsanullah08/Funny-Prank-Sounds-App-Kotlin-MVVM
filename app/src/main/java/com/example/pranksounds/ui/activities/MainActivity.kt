package com.example.pranksounds.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pranksounds.R
import com.example.pranksounds.databinding.ActivityMainBinding
import com.example.pranksounds.utils.ads.AdsHelper
import com.example.pranksounds.ui.viewModels.HeaderViewModel
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var headerViewModel: HeaderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializations()
        setupViews()
    }

    private fun initializations() {
        // NOTE always use test ads during development and testing
        //StartAppSDK.setTestAdsEnabled(BuildConfig.DEBUG);

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)

        AdsHelper.initializeAdmob(this)
    }

    private fun setupViews() {
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)

        headerViewModel = ViewModelProvider(this)[HeaderViewModel::class.java]
        headerViewModel.headerText.observe(this) {
            binding.tvHeader.text = it
        }
    }

    fun onSettingsClick(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
    }
}