package com.example.demoapp.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.demoapp.RoomDB
import com.example.demoapp.SessionManager
import com.example.demoapp.utils.Utils
import com.example.demoapp.model.CartProduct
import kotlinx.coroutines.launch

class CartViewModel(application: Application,context: Context): AndroidViewModel(application) {
    private var repository:CartViewModelRepository

    var  products: LiveData<List<CartProduct>>

    var TAG=javaClass.simpleName
    init {
        val productDao= RoomDB.getInstance(application).getAppDatabase().getCartProductDao()
        repository= CartViewModelRepository(productDao,SessionManager.getUserName(context).toString())
        products=repository.products
        Log.d(TAG, Utils.category)
    }

    fun add(product: CartProduct)= viewModelScope.launch {
        repository.add(product)
    }

}