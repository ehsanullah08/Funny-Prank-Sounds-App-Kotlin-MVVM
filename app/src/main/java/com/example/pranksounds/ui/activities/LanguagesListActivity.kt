package com.example.pranksounds.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pranksounds.data.models.LanguageItem
import com.example.pranksounds.databinding.ActivityLanguagesListBinding
import com.example.pranksounds.ui.adapters.LanguageClickListener
import com.example.pranksounds.ui.adapters.LanguagesListAdapter
import com.example.pranksounds.utils.Constants
import com.example.pranksounds.utils.LangHelper
import com.example.pranksounds.utils.Utils
import com.example.pranksounds.ui.viewModels.LanguagesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LanguagesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguagesListBinding
    private val languagesListViewModel: LanguagesListViewModel by viewModels()
    private lateinit var languagesList: List<LanguageItem>
    private lateinit var languagesListAdapter: LanguagesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLanguagesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapterOnLanguagesList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupAdapterOnLanguagesList() {
        languagesList = languagesListViewModel.getLanguagesList(this)
        val currentLanCode = LangHelper.getCurrentLocale(this)?.language

        currentLanCode?.let {
            languagesList.first { it.languageCode == currentLanCode }.isSelected = true
        }?:run {
            languagesList.first { it.languageCode == LangHelper.ENGLISH }.isSelected = true
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

            LangHelper.ENGLISH -> {
                LangHelper.changeLanguage(this, LangHelper.ENGLISH)
            }

            LangHelper.URDU -> {
                LangHelper.changeLanguage(this, LangHelper.URDU)
            }

            LangHelper.HINDI -> {
                LangHelper.changeLanguage(this, LangHelper.HINDI)
            }

            LangHelper.ARABIC -> {
                LangHelper.changeLanguage(this, LangHelper.ARABIC)
            }

            LangHelper.SPANISH -> {
                LangHelper.changeLanguage(this, LangHelper.SPANISH)
            }

            LangHelper.CHINESE -> {
                LangHelper.changeLanguage(this, LangHelper.CHINESE)
            }

            LangHelper.DUTCH -> {
                LangHelper.changeLanguage(this, LangHelper.DUTCH)
            }

            LangHelper.PORTUGUESE -> {
                LangHelper.changeLanguage(this, LangHelper.PORTUGUESE)
            }
        }

        Utils.restartApp(this)
    }

    fun onIvBackClick(view: View) {
        finish()
    }
}