package com.ibrahim.papb.roomdb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.papb.roomdb.database.ItemDTO
import com.ibrahim.papb.roomdb.databinding.ItemLayoutBinding

class ItemRvAdapter : ListAdapter<ItemDTO, ItemRvAdapter.RecyclerViewViewHolder>(DiffUtilCallback()) {

    class RecyclerViewViewHolder private constructor(private val binding : ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemDTO: ItemDTO){
            binding.item = itemDTO
        }

        companion object{
            fun from(parent : ViewGroup) : RecyclerViewViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)

                return RecyclerViewViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        return RecyclerViewViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffUtilCallback : DiffUtil.ItemCallback<ItemDTO>(){
    override fun areItemsTheSame(oldItem: ItemDTO, newItem: ItemDTO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemDTO, newItem: ItemDTO): Boolean {
        return oldItem == newItem
    }
}