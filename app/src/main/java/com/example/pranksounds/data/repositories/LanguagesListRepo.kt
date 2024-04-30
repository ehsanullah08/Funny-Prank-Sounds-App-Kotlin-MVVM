package com.example.pranksounds.data.repositories

import android.content.Context
import com.example.pranksounds.R
import com.example.pranksounds.data.models.LanguageItem
import com.example.pranksounds.utils.Constants

class LanguagesListRepo {

    companion object {

        fun getLanguagesList(context: Context): List<LanguageItem> {
            val languagesList = ArrayList<LanguageItem>()
            languagesList.add(LanguageItem(0, context.getString(R.string.english), Constants.ENGLISH_CODE,false))
            languagesList.add(LanguageItem(1, context.getString(R.string.urdu),Constants.URDU_CODE, false))
            languagesList.add(LanguageItem(2, context.getString(R.string.hindi), Constants.HINDI_CODE,false))
            languagesList.add(LanguageItem(3, context.getString(R.string.arabic),Constants.ARABIC_CODE, false))
            languagesList.add(LanguageItem(4, context.getString(R.string.spanish),Constants.SPANISH_CODE, false))
            languagesList.add(LanguageItem(5, context.getString(R.string.portuguese),Constants.PORTUGUESE_CODE, false))
            languagesList.add(LanguageItem(6, context.getString(R.string.chinese),Constants.CHINESE_CODE, false))
            languagesList.add(LanguageItem(7, context.getString(R.string.dutch),Constants.DUTCH_CODE, false))

            return languagesList
        }
    }
}