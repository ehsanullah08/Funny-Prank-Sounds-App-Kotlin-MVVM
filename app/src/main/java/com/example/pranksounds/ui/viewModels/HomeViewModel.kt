package com.example.pranksounds.ui.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pranksounds.data.models.SoundCategoryItem
import com.example.pranksounds.data.repositories.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepo: HomeRepo) : ViewModel() {

    fun getAllSoundCategories(context: Context): List<SoundCategoryItem> {
        return homeRepo.getSoundCategories(context)
    }
}