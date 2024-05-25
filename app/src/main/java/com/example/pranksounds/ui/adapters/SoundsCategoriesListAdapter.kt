package com.example.pranksounds.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pranksounds.data.models.SoundCategoryItem
import com.example.pranksounds.databinding.ItemSoundCategoryListBinding
import com.example.pranksounds.ui.viewHolders.SoundCategoryViewHolder

class SoundsCategoriesListAdapter(private val categoriesList: List<SoundCategoryItem>, private val soundCategoryListener: SoundCategoryClickListener) :
    RecyclerView.Adapter<SoundCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSoundCategoryListBinding.inflate(inflater, parent, false)
        return SoundCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: SoundCategoryViewHolder, position: Int) {
        val sound = categoriesList[position]
        holder.bind(sound, soundCategoryListener)
    }
}

class SoundCategoryClickListener(val clickListener: (categoryItem: SoundCategoryItem) -> Unit) {
    fun onClick(categoryItem: SoundCategoryItem) = clickListener(categoryItem)
}