package com.example.pranksounds.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pranksounds.data.models.LanguageItem
import com.example.pranksounds.databinding.ActivityLanguagesListBinding
import com.example.pranksounds.ui.adapters.LanguageClickListener
import com.example.pranksounds.ui.adapters.LanguagesListAdapter
import com.example.pranksounds.utils.Constants
import com.example.pranksounds.utils.LangHelper
import com.example.pranksounds.utils.Utils
import com.example.pranksounds.viewModels.LanguagesListViewModel

class LanguagesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguagesListBinding
    private lateinit var languagesListViewModel: LanguagesListViewModel
    private lateinit var languagesList: List<LanguageItem>
    private lateinit var languagesListAdapter: LanguagesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLanguagesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        languagesListViewModel =
            ViewModelProvider(this)[LanguagesListViewModel::class.java]

        setupAdapterOnLanguagesList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupAdapterOnLanguagesList() {
        languagesList = languagesListViewModel.getLanguagesList(this)
        val currentLanCode = LangHelper.getCurrentLocale(this)?.language

        currentLanCode?.let {
            languagesList.first { it.languageCode == currentLanCode }.isSelected = true
        }?:run {
            languagesList.first { it.languageCode == Constants.ENGLISH_CODE }.isSelected = true
        }

        languagesListAdapter =
            LanguagesListAdapter(languagesList, LanguageClickListener { item: LanguageItem ->

                languagesList.forEach { it.isSelected = (it.languageId == item.languageId) }
                languagesListAdapter.notifyDataSetChanged()
            })

        binding.rvLanguagesList.adapter = languagesListAdapter
    }

    fun onIvLanguageChangeClick(view: View) {

        when (languagesList.first{ it.isSelected }.languageCode) {

            Constants.ENGLISH_CODE -> {
                LangHelper.changeLanguage(this, LangHelper.ENGLISH)
            }

            Constants.URDU_CODE -> {
                LangHelper.changeLanguage(this, LangHelper.URDU)
            }

            Constants.HINDI_CODE -> {
                LangHelper.changeLanguage(this, LangHelper.HINDI)
            }

            Constants.ARABIC_CODE -> {
                LangHelper.changeLanguage(this, LangHelper.ARABIC)
            }

            Constants.SPANISH_CODE -> {
                LangHelper.changeLanguage(this, LangHelper.SPANISH)
            }

            Constants.CHINESE_CODE -> {
                LangHelper.changeLanguage(this, LangHelper.CHINESE)
            }

            Constants.DUTCH_CODE -> {
                LangHelper.changeLanguage(this, LangHelper.DUTCH)
            }
        }

        Utils.restartApp(this)
    }

    fun onIvBackClick(view: View) {
        finish()
    }
}