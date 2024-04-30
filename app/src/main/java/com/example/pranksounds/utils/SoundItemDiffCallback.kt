package com.example.pranksounds.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.pranksounds.data.models.SoundItem

class SoundItemDiffCallback(
    private val oldList: List<SoundItem>,
    private val newList: List<SoundItem>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].soundId == newList[newItemPosition].soundId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
