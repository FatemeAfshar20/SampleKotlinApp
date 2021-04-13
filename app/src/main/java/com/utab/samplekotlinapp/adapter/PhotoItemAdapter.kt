package com.utab.samplekotlinapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.utab.samplekotlinapp.R
import com.utab.samplekotlinapp.data.PhotoItem
import com.utab.samplekotlinapp.databinding.ItemViewBinding

class PhotoItemAdapter(private val listPhotoItems: List<PhotoItem>) :
    RecyclerView.Adapter<PhotoItemAdapter.Holder>() {

    class Holder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(photoUrl: String) {
            binding.photoUrl = photoUrl
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = DataBindingUtil.inflate<ItemViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_view,
            parent,
            false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        listPhotoItems[position].url_s?.let { holder.bindView(it) }
    }

    override fun getItemCount(): Int {
        return listPhotoItems.size
    }
}