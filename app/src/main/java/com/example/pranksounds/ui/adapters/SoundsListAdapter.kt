package com.example.pranksounds.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.databinding.ItemSoundsListBinding
import com.example.pranksounds.ui.viewHolders.SoundViewHolder

class SoundsListAdapter(private val soundsList: List<SoundItem>, private val cityListener: SoundClickListener) :
    RecyclerView.Adapter<SoundViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSoundsListBinding.inflate(inflater, parent, false)
        return SoundViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return soundsList.size
    }

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        val sound = soundsList[position]
        holder.bind(sound, cityListener)
    }
}

class SoundClickListener(val clickListener: (soundItem: SoundItem) -> Unit) {
    fun onClick(soundItem: SoundItem) = clickListener(soundItem)
}