package com.example.demoapp.adapter

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoapp.R
import com.example.demoapp.model.CartProduct
import com.example.demoapp.utils.Utils


class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(cardProduct: CartProduct,context: Context){

        val imageView:ImageView=itemView.findViewById(R.id.imageview_card)
        Glide.with(context).load(cardProduct.pImageUrl).into(imageView)
        val textViewName:TextView=itemView.findViewById(R.id.textview_name)
        textViewName.text = cardProduct.pName
        val textViewPrice:TextView=itemView.findViewById(R.id.textview_price)
        textViewPrice.text ="$ "
        textViewPrice.append(cardProduct.price.toString())
        val textViewQuantity:TextView=itemView.findViewById(R.id.textview_quantity)
        textViewQuantity.text = "Quantity: "
        textViewQuantity.append(cardProduct.quantity.toString())
        val textViewCategory:TextView=itemView.findViewById(R.id.textview_category)
        textViewCategory.text = "Category: "
        textViewCategory.append(cardProduct.category)
        Utils.totalCost= Utils.totalCost+(cardProduct.price*cardProduct.quantity)
        //val textView:TextView=(application as Activity).findViewById(R.id.textview_total_amount)
        //textView.text = Utils.totalCost.toString()
        //Toast.makeText(context,Utils.totalCost.toString(),Toast.LENGTH_SHORT).show()

    }
}