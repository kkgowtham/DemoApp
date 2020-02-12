package com.example.demoapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.demoapp.RoomDB
import com.example.demoapp.utils.Utils
import com.example.demoapp.model.Product
import kotlinx.coroutines.launch

public class ProductViewModel(application: Application): AndroidViewModel(application) {

    private var repository:ProductViewModelRepository

    var  products:LiveData<List<Product>>

    var TAG=javaClass.simpleName
    init {
        val productDao=RoomDB.getInstance(application).getAppDatabase().getProductDao()
        repository= ProductViewModelRepository(productDao)
        products=repository.products
        Log.d(TAG, Utils.category)
    }

    fun add(product: Product)= viewModelScope.launch {
        repository.add(product)
    }
}