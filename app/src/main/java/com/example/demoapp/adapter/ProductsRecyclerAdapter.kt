package com.example.demoapp.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.util.Util
import com.example.demoapp.ProductActivity
import com.example.demoapp.R
import com.example.demoapp.model.Product
import com.example.demoapp.utils.Utils

class ProductsRecyclerAdapter(private var context: Context, private var list: List<Product>) :
    RecyclerView.Adapter<ProductViewHolder>() {


    var TAG=javaClass.simpleName
    init {
        Log.d(TAG,list.toString())
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.product_card,parent,false)
        Log.d(TAG,"OnCreate View Holder")
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        Log.d(TAG,"OnBind View Holder")
        holder.bind(list[position],context)
        holder.itemView.setOnClickListener{
            val intent = Intent(context, ProductActivity::class.java)
            intent.putExtra("id", list[position].pId.toString())
            intent.putExtra("category",list[position].category)
            intent.putExtra("name",list[position].pName)
            intent.putExtra("imageurl",list[position].pImageUrl)
            intent.putExtra("price",list[position].price.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        Log.d(TAG,list.size.toString())
        return list.size
    }

    fun setData(newData: List<Product>){
        list = newData
        notifyDataSetChanged()
    }

}