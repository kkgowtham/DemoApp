package com.example.demoapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.demoapp.dao.ProductDao
import com.example.demoapp.utils.Utils
import com.example.demoapp.model.Product

class ProductViewModelRepository(private val productDao: ProductDao){

    val products:LiveData<List<Product>> = productDao.getAllProducts(Utils.category)
    var TAG=javaClass.simpleName

    init {
        Log.d(TAG, Utils.category)

    }
     suspend fun add(product: Product){
        productDao.addProduct(product)
    }
}