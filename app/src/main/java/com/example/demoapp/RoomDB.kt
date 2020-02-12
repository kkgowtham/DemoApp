package com.example.demoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


class RoomDB(private val context: Context) {

    private  var database:AppDatabase


    init {
        database=Room.databaseBuilder(context,AppDatabase::class.java,"productdb")
            .fallbackToDestructiveMigration()
            .build()
    }


    companion object{
        @Volatile
        private var mInstance:RoomDB? = null

        @Synchronized
        fun getInstance(context: Context):RoomDB {
            if(mInstance == null){
                    mInstance = RoomDB(context)
            }
            return mInstance!!
        }

    }

    public fun getAppDatabase():AppDatabase{
        return database
    }

}