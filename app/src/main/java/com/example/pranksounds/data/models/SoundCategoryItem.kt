package com.example.pranksounds.data.models

import android.os.Parcel
import android.os.Parcelable

data class SoundCategoryItem(
    var categoryId: Int,
    var title: String,
    var colorCode: Int?,
    var bgImage: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(categoryId)
        parcel.writeString(title)
        parcel.writeValue(colorCode)
        parcel.writeInt(bgImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SoundCategoryItem> {
        override fun createFromParcel(parcel: Parcel): SoundCategoryItem {
            return SoundCategoryItem(parcel)
        }

        override fun newArray(size: Int): Array<SoundCategoryItem?> {
            return arrayOfNulls(size)
        }
    }
}