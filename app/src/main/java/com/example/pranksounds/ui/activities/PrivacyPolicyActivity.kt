package com.example.pranksounds.ui.activities

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pranksounds.R
import com.example.pranksounds.databinding.ActivityPrivacyPolicyBinding
import com.example.pranksounds.databinding.ActivitySettingsBinding

class PrivacyPolicyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrivacyPolicyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrivacyPolicyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadPrivacyPolicy()
    }

    private fun loadPrivacyPolicy() {
        binding.webView.settings.javaScriptEnabled = true // Warning: Be cautious with JavaScript due to security risks
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl("file:///android_asset/privacy_policy.html")
    }

    fun onIvBackClick(view: View) {
        finish()
    }
}