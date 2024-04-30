package com.example.pranksounds.data.models

import android.os.Parcel
import android.os.Parcelable

data class SoundItem(
    var soundId: Int,
    var title: String,
    var colorCode: Int?,
    var fileName: String?,
    var bgImage: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(soundId)
        parcel.writeString(title)
        parcel.writeValue(colorCode)
        parcel.writeString(fileName)
        parcel.writeInt(bgImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SoundItem> {
        override fun createFromParcel(parcel: Parcel): SoundItem {
            return SoundItem(parcel)
        }

        override fun newArray(size: Int): Array<SoundItem?> {
            return arrayOfNulls(size)
        }
    }
}