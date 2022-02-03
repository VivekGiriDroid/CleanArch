package com.vkydroid.cleanarch.presentation.adapter

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vkydroid.cleanarch.databinding.ItemPeopleBinding

class PeopleAdapterViewHolder(binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root) {
    val textView: TextView = binding.tvPeopleName
}