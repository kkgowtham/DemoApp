package com.example.demoapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.adapter.ProductsRecyclerAdapter
import com.example.demoapp.model.Product
import com.example.demoapp.viewmodel.ProductViewModel

class UserFragment:Fragment() {
    lateinit var list: List<Product>
    lateinit var mContext: Context
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductsRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.user_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerview_user)
        getData()
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private fun getData() {
        list = ArrayList()
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)
        val viewModel: ProductViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        viewModel.products.observe(viewLifecycleOwner, Observer<List<Product>> {
            list = it.toList()
            adapter = ProductsRecyclerAdapter(
                mContext,
                list
            )
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
            Log.d(javaClass.simpleName, list.toString())
            //adapter.setData(list)
        })

    }
}