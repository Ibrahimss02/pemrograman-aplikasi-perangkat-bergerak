package com.ibrahim.papb.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class ItemAdapter(val listItem : ArrayList<Item>, private val context : Context) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    companion object{
        const val ITEM_NAME = "ITEM_NAME"
    }

    inner class ItemViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvItem : TextView = view.findViewById(R.id.tvItem)
        val btnItem : MaterialButton = view.findViewById(R.id.btnItem)

        fun bind(item : Item){
            tvItem.text = item.nama

            btnItem.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(ITEM_NAME, tvItem.text)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]

        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}