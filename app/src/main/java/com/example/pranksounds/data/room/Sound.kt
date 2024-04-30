package com.example.pranksounds.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pranksounds.utils.Constants

@Entity(tableName = Constants.SOUNDS_TABLE)
data class Sound(
    @PrimaryKey(autoGenerate = false) val soundId: Int,
    val title: String,
    val colorCode: Int,
    val fileName: String,
    val bgImage: Int
)