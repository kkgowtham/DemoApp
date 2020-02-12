package com.example.demoapp.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoapp.R
import com.example.demoapp.model.Product

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(product:Product,context:Context){
        val imageView: ImageView = itemView.findViewById(R.id.imageViewCard)
        Glide.with(context).load(product.pImageUrl).into(imageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextViewCard)
        nameTextView.text=product.pName
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextViewCard)
        priceTextView.text="$"+product.price.toString()
    }

}