package com.ibrahim.papb.roomdb.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.papb.roomdb.ItemRvAdapter
import com.ibrahim.papb.roomdb.database.ItemDTO

@BindingAdapter("listDataItem")
fun bindItems(recyclerView: RecyclerView, data : List<ItemDTO>?){
    val adapter = recyclerView.adapter as ItemRvAdapter
    adapter.submitList(data)
}