package com.example.pranksounds.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pranksounds.data.models.LanguageItem
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.databinding.ItemLanguagesListBinding
import com.example.pranksounds.ui.viewHolders.LanguagesListViewHolder

class LanguagesListAdapter(
    private val languagesList: List<LanguageItem>,
    private val languageListener: LanguageClickListener
) :
    RecyclerView.Adapter<LanguagesListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguagesListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLanguagesListBinding.inflate(inflater, parent, false)
        return LanguagesListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return languagesList.size
    }

    override fun onBindViewHolder(holder: LanguagesListViewHolder, position: Int) {
        val language = languagesList[position]
        holder.bind(language, languageListener)
    }
}

class LanguageClickListener(val clickListener: (languageItem: LanguageItem) -> Unit) {
    fun onClick(languageItem: LanguageItem) = clickListener(languageItem)
}