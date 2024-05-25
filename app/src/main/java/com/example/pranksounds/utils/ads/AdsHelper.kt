package com.example.pranksounds.utils.ads

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.ads.mediation.admob.AdMobAdapter
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.startapp.sdk.ads.banner.Banner
import com.startapp.sdk.adsbase.StartAppAd
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.random.Random


object AdsHelper {


    private val isMobileAdsInitializeCalled = AtomicBoolean(false)
    private lateinit var googleMobileAdsConsentManager: GoogleMobileAdsConsentManager


    fun initializeAdmob(context: Context){
        MobileAds.initialize(context) {}
    }

    fun loadBannerAdWithConsent(
        activity: AppCompatActivity,
        bannerPlaceHolder: FrameLayout,
        unitId: String,
        bannerAdSize: AdSize
    ) {
        googleMobileAdsConsentManager =
            GoogleMobileAdsConsentManager.getInstance(activity)
        googleMobileAdsConsentManager.gatherConsent(activity) { consentError ->
            if (consentError != null) {
                // Consent not obtained in current session.
                Log.w("PlaySoundActivity", "${consentError.errorCode}. ${consentError.message}")
            }
        }

        // This sample attempts to load ads using consent obtained in the previous session.
        if (googleMobileAdsConsentManager.canRequestAds) {
            /*if (isMobileAdsInitializeCalled.getAndSet(true)) {//it stops the ad to load again and again
                return
            }*/
            loadBannerAd(activity, bannerPlaceHolder, unitId, bannerAdSize)
        }
    }

    private fun loadBannerAd(
        applicationContext: Context,
        bannerPlaceHolder: FrameLayout,
        unitId: String,
        bannerAdSize: AdSize
    ) {
        val adView = AdView(applicationContext)
        bannerPlaceHolder.addView(adView)
        // This is an ad unit ID for a test ad. Replace with your own banner ad unit ID.
        adView.adUnitId = unitId
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
                loadStartappBannerAd(applicationContext, bannerPlaceHolder)
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

    fun loadStartappBannerAd(applicationContext: Context, bannerPlaceHolder: FrameLayout) {
        val banner = Banner(applicationContext)
        bannerPlaceHolder.addView(banner)
    }

    fun loadInterstitialAdWithConsent( activity: AppCompatActivity, unitId: String) {
        googleMobileAdsConsentManager =
            GoogleMobileAdsConsentManager.getInstance(activity)
        googleMobileAdsConsentManager.gatherConsent(activity) { consentError ->
            if (consentError != null) {
                // Consent not obtained in current session.
                Log.w("PlaySoundActivity", "${consentError.errorCode}. ${consentError.message}")
            }
        }

        // This sample attempts to load ads using consent obtained in the previous session.
        if (googleMobileAdsConsentManager.canRequestAds) {
            /*if (isMobileAdsInitializeCalled.getAndSet(true)) {
                return
            }*/
            loadInterstitialAd(activity, unitId)
        }
    }

    private fun loadInterstitialAd(activity: AppCompatActivity, unitId: String) {
        val adRequest: AdRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            activity,
            unitId,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    val error =
                        "domain: ${adError.domain}, code: ${adError.code}, " + "message: ${adError.message}"

                    StartAppAd.showAd(activity)
                }

                override fun onAdLoaded(ad: InterstitialAd) {

                    ad.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {

                            }

                            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                StartAppAd.showAd(activity)
                            }

                            override fun onAdShowedFullScreenContent() {

                            }
                        }

                    ad.show(activity)
                }
            }
        )
    }
}
