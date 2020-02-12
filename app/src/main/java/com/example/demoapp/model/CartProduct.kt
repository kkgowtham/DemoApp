package com.example.demoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cartproduct")
data class CartProduct
    (@PrimaryKey(autoGenerate = true) var id:Long?,
     @ColumnInfo(name="pid") var pId:String,
     @ColumnInfo(name="productname") var pName:String,
     @ColumnInfo(name = "price") var price:Double,
     @ColumnInfo(name="productimageurl") var pImageUrl:String,
     @ColumnInfo(name = "category") var category: String,
     @ColumnInfo(name = "quantity") var quantity:Int,
     @ColumnInfo(name = "userid") var userid:String
)
{
    constructor():this(null,"","",0.0,"","",0,"")
}