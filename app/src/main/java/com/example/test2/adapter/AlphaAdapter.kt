package com.example.test2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.test2.R
import com.example.test2.model.AlphaCard

class AlphaAdapter(context: Context, arrayList:List<AlphaCard> ): RecyclerView.Adapter<AlphaAdapter.ItemHolder>() {

    private var list: List<AlphaCard> = arrayList;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list_item,parent,false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val alfaCard:AlphaCard = list.get(position)

        holder.icon.setImageResource(alfaCard.icons!!)
        holder.title.text = alfaCard.text;
    }
    fun submitList(items:List<AlphaCard>){
        list = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var icon = itemView.findViewById<ImageView>(R.id.icon_image_view)
        var title = itemView.findViewById<TextView>(R.id.title_text_view)
    }
}