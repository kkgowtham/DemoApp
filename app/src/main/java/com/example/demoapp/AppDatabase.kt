package com.example.demoapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.demoapp.dao.CartProductDao
import com.example.demoapp.dao.ProductDao
import com.example.demoapp.model.CartProduct
import com.example.demoapp.model.Product

@Database(entities = [Product::class,CartProduct::class] ,version = 1,exportSchema= false)
abstract class AppDatabase:RoomDatabase() {

     abstract fun  getProductDao(): ProductDao

     abstract fun getCartProductDao(): CartProductDao

}