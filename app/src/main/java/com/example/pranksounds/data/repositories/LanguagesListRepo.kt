package com.example.pranksounds.data.repositories

import android.content.Context
import com.example.pranksounds.R
import com.example.pranksounds.data.models.LanguageItem
import com.example.pranksounds.utils.Constants
import com.example.pranksounds.utils.LangHelper

class LanguagesListRepo {
    fun getLanguagesList(context: Context): List<LanguageItem> {
        val languagesList = ArrayList<LanguageItem>()
        languagesList.add(
            LanguageItem(
                0,
                context.getString(R.string.english),
                LangHelper.ENGLISH,
                false
            )
        )
        languagesList.add(
            LanguageItem(
                1,
                context.getString(R.string.urdu),
                LangHelper.URDU,
                false
            )
        )
        languagesList.add(
            LanguageItem(
                2,
                context.getString(R.string.hindi),
                LangHelper.HINDI,
                false
            )
        )
        languagesList.add(
            LanguageItem(
                3,
                context.getString(R.string.arabic),
                LangHelper.ARABIC,
                false
            )
        )
        languagesList.add(
            LanguageItem(
                4,
                context.getString(R.string.spanish),
                LangHelper.SPANISH,
                false
            )
        )
        languagesList.add(
            LanguageItem(
                5,
                context.getString(R.string.portuguese),
                LangHelper.PORTUGUESE,
                false
            )
        )
        languagesList.add(
            LanguageItem(
                6,
                context.getString(R.string.chinese),
                LangHelper.CHINESE,
                false
            )
        )
        languagesList.add(
            LanguageItem(
                7,
                context.getString(R.string.dutch),
                LangHelper.DUTCH,
                false
            )
        )

        return languagesList
    }
}
