package com.example.demoapp

import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.adapter.CartRecyclerAdapter
import com.example.demoapp.model.CartProduct
import com.example.demoapp.utils.Utils
import com.example.demoapp.viewmodel.CartViewModel
import com.example.demoapp.viewmodel.MyViewModelFactory

import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter:CartRecyclerAdapter
    lateinit var list:List<CartProduct>
    lateinit var viewModel:CartViewModel
    lateinit var TAG:String
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        list=ArrayList()
        textView=findViewById(R.id.textview_total_amount)
        TAG=javaClass.simpleName
        setSupportActionBar(toolbar)
        recyclerView=findViewById(R.id.cart_items_recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        recyclerView.setHasFixedSize(true)
        viewModel=ViewModelProvider(this,MyViewModelFactory(this.application,applicationContext)).get(CartViewModel::class.java)
        viewModel.products.observe(this,Observer<List<CartProduct>>{
            list=it.toList()
            adapter=CartRecyclerAdapter(applicationContext,list)
            recyclerView.adapter=adapter
            adapter.notifyDataSetChanged()
            textView.text = Utils.totalCost.toString()
            Log.d(TAG,list.toString())
        })
        Handler().postDelayed({
            //Do something after 100ms
            if(list.size>0)
            {
                textView.text="$"+Utils.totalCost.toString()
            }else{
                textView.text="Not Items in the cart"
                textView.setBackgroundColor(Color.RED)
            }

        }, 100)
    }

}
