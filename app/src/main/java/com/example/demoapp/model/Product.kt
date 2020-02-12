package com.example.demoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product
    (@PrimaryKey(autoGenerate = true) val pId:Long?,
     @ColumnInfo(name="productname") var pName:String,
     @ColumnInfo(name = "price") var price:Double,
     @ColumnInfo(name="productimageurl") var pImageUrl:String,
     @ColumnInfo(name = "category") var category: String
)
{
    constructor():this(null,"",0.0,"","")
}