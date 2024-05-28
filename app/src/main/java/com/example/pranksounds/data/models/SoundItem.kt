package com.example.pranksounds.data.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pranksounds.utils.Constants

@Entity(tableName = Constants.SOUNDS_TABLE)
data class SoundItem(
    @PrimaryKey(autoGenerate = false) val soundId: Int,
    val title: String,
    val colorCode: Int,
    val fileName: String,
    val bgImage: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readValue(Int::class.java.classLoader) as Int,
        parcel.readString()!!,
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