package com.example.pranksounds.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pranksounds.data.source.local.SoundItem
import com.example.pranksounds.databinding.ItemFavSoundsListBinding
import com.example.pranksounds.ui.viewHolders.FavSoundViewHolder

import androidx.recyclerview.widget.DiffUtil
import com.example.pranksounds.utils.SoundItemDiffCallback

class FavSoundsListAdapter(private val soundListener: FavSoundClickListener) : RecyclerView.Adapter<FavSoundViewHolder>() {

    private var soundItemList: List<SoundItem> = listOf()

    fun setData(newSoundItemList: List<SoundItem>) {
        val diffResult = DiffUtil.calculateDiff(SoundItemDiffCallback(soundItemList, newSoundItemList))
        soundItemList = newSoundItemList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavSoundViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFavSoundsListBinding.inflate(inflater, parent, false)
        return FavSoundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavSoundViewHolder, position: Int) {
        holder.bind(soundItemList[position], soundListener)
    }

    override fun getItemCount(): Int {
        return soundItemList.size
    }
}

class FavSoundClickListener(val clickListener: (soundItem: SoundItem) -> Unit) {
    fun onClick(soundItem: SoundItem) = clickListener(soundItem)
}