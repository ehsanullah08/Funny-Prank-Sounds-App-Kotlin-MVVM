package com.example.pranksounds.ui.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.pranksounds.data.source.local.SoundItem
import com.example.pranksounds.databinding.ItemFavSoundsListBinding
import com.example.pranksounds.ui.adapters.FavSoundClickListener

class FavSoundViewHolder(private var binding: ItemFavSoundsListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        soundItem: SoundItem,
        clickListener: FavSoundClickListener
    ) {
        binding.soundItem = soundItem
        binding.executePendingBindings()
        binding.favSoundClickListener = clickListener
    }
}
