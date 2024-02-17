package com.example.android3_5.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android3_5.data.models.Data
import com.example.android3_5.databinding.ItemHarryBinding

class HarryAdapter : RecyclerView.Adapter<HarryAdapter.HarryViewHolder>() {


    private val _harryList = mutableListOf<Data>()

    fun setHarryCharacter(harryList: List<Data>) {
        this._harryList.addAll(harryList)
        this._harryList.distinctBy {
            it.id
        }
        notifyDataSetChanged()

    }

    inner class HarryViewHolder(private val binding: ItemHarryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(harryPoterResponce: Data) = with(binding) {
            val imageUrl = harryPoterResponce.attributes.image

            Glide.with(ivItem)
                .load(imageUrl)
                .into(ivItem)
            textItem.text = harryPoterResponce.attributes.slug
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HarryViewHolder {
        val binding =
            ItemHarryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HarryViewHolder(binding)
    }

    override fun getItemCount() = _harryList.size


    override fun onBindViewHolder(holder: HarryViewHolder, position: Int) {
        holder.onBind(_harryList[position])
    }
}
