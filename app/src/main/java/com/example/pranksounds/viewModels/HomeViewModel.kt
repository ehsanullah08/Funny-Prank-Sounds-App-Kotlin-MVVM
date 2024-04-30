package com.example.pranksounds.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pranksounds.data.models.SoundCategoryItem
import com.example.pranksounds.data.repositories.HomeRepo

class HomeViewModel : ViewModel() {

    fun getAllSoundCategories(context: Context): List<SoundCategoryItem> {
        return HomeRepo.getSoundCategories(context)
    }
}