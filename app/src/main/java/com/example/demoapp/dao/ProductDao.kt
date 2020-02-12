package com.example.demoapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.demoapp.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM product WHERE category=:category")
   fun getAllProducts(category: String):LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: Product)

}