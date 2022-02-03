package com.vkydroid.cleanarch.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vkydroid.cleanarch.R
import com.vkydroid.cleanarch.databinding.ItemPeopleBinding
import com.vkydroid.cleanarch.domain.People

class PeopleAdapter(
    private val items: List<People>
) : RecyclerView.Adapter<PeopleAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleAdapterViewHolder {
        val binding = DataBindingUtil.inflate<ItemPeopleBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_people, parent, false
        )
        return PeopleAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleAdapterViewHolder, position: Int) {
        holder.textView.text = items[position].name
    }

    override fun getItemCount(): Int {
        return items.size
    }


}