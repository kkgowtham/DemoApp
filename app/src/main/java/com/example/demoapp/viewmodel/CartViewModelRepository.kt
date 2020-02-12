package com.example.demoapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.demoapp.utils.Utils
import com.example.demoapp.dao.CartProductDao
import com.example.demoapp.model.CartProduct

class CartViewModelRepository(private val cartProductDao: CartProductDao,userid:String) {
    val products: LiveData<List<CartProduct>> = cartProductDao.getAllCartProducts(userid)

    var TAG=javaClass.simpleName

    init {
        Log.d(TAG, Utils.category)

        Log.d(TAG,userid)
    }
    suspend fun add(product: CartProduct){
        cartProductDao.addProduct(product)
    }

}