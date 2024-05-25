package com.example.pranksounds.ui.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.pranksounds.data.source.local.SoundItem
import com.example.pranksounds.databinding.ItemSoundsListBinding
import com.example.pranksounds.ui.adapters.SoundClickListener

class SoundViewHolder(private var binding: ItemSoundsListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        soundItem: SoundItem,
        clickListener: SoundClickListener
    ) {
        binding.soundItem = soundItem
        binding.executePendingBindings()
        binding.soundClickListener = clickListener
    }
}
