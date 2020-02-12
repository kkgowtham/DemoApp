package com.example.demoapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.demoapp.model.CartProduct
import com.example.demoapp.model.Product

@Dao
interface CartProductDao {
    @Query("SELECT * FROM cartproduct WHERE userid=:userid")
    fun getAllCartProducts(userid:String): LiveData<List<CartProduct>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addProduct(product: CartProduct)
}