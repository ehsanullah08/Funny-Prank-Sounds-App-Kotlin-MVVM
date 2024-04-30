package com.example.pranksounds.data.models

import android.os.Parcel
import android.os.Parcelable

data class LanguageItem(
    var languageId: Int,
    var languageName: String,
    var languageCode: String,
    var isSelected: Boolean
)