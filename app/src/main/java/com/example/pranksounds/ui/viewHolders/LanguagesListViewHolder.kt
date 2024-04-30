package com.example.pranksounds.ui.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.pranksounds.data.models.LanguageItem
import com.example.pranksounds.databinding.ItemLanguagesListBinding
import com.example.pranksounds.ui.adapters.LanguageClickListener

class LanguagesListViewHolder(private val binding: ItemLanguagesListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        languageItem: LanguageItem,
        clickListener: LanguageClickListener
    ) {
        binding.languageItem = languageItem
        binding.executePendingBindings()
        binding.languageClickListener = clickListener
    }
}
