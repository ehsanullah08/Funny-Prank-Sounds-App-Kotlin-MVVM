package com.example.pranksounds.ui.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.pranksounds.data.models.SoundCategoryItem
import com.example.pranksounds.databinding.ItemSoundCategoryListBinding
import com.example.pranksounds.databinding.ItemSoundsListBinding
import com.example.pranksounds.ui.adapters.SoundCategoryClickListener

class SoundCategoryViewHolder(private var binding: ItemSoundCategoryListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        categoryItem: SoundCategoryItem,
        clickListener: SoundCategoryClickListener
    ) {
        binding.categoryItem = categoryItem
        binding.executePendingBindings()
        binding.soundCategoryClickListener = clickListener
    }
}
