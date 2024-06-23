package com.group4.loginapptk2.home.aapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.group4.loginapptk2.databinding.ItemHomeBinding
import com.group4.loginapptk2.home.model.HomeModel

class HomeAdapter : PagingDataAdapter<HomeModel, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    private val VIEW_ITEM = 0

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<HomeModel>() {
            override fun areItemsTheSame(oldItem: HomeModel, newItem: HomeModel): Boolean {
                return oldItem.imageId == newItem.imageId
            }

            override fun areContentsTheSame(oldItem: HomeModel, newItem: HomeModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemHomeBinding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ItemViewHolder(itemHomeBinding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as ItemViewHolder
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_ITEM
    }

    override fun getItemCount(): Int {
        return snapshot().items.size
    }

    class ItemViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeModel) {
            with(binding) {
                imageView.setImageResource(item.imageId)
                tvTitle.text = item.title
                tvLikes.text = "${item.likes} likes"
            }
        }
    }
}