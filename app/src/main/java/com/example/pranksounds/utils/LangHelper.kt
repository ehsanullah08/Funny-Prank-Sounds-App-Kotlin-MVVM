package com.example.pranksounds.utils

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import java.util.Locale


object LangHelper {

    const val ENGLISH = "en"
    const val URDU = "ur"
    const val ARABIC = "ar"
    const val HINDI = "hi"
    const val SPANISH = "es"
    const val CHINESE = "zh"
    const val DUTCH = "nl"


    fun changeLanguage(context: Context, languageCode: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.getSystemService(LocaleManager::class.java)
                .applicationLocales = LocaleList.forLanguageTags(languageCode)
        } else {
            AppCompatDelegate.setApplicationLocales(
                LocaleListCompat.forLanguageTags(
                    languageCode
                )
            )
        }
    }

    fun getCurrentLocale(context: Context): Locale? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val currentLocal = context.getSystemService(LocaleManager::class.java)
                .applicationLocales

            return currentLocal[0]
        } else {
            val currentAppLocales =
                AppCompatDelegate.getApplicationLocales()
            return currentAppLocales[0]
        }
    }
}
