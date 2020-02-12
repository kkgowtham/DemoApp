package com.example.demoapp

import android.content.Context
import android.content.SharedPreferences

object SessionManager{

        var MODE=0
        var name="demo"

        fun save(context: Context,username:String,password:String,isAdmin:Boolean) {
            val sharedPreferences: SharedPreferences =context.getSharedPreferences(name,MODE)
            val editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("username",username)
            editor.putString("password",password)
            editor.putBoolean("isAdmin",isAdmin)
            editor.apply()

        }

        fun  isAdmin(context: Context):Boolean
        {
            val sharedPreferences: SharedPreferences =context.getSharedPreferences(name,MODE)
            return sharedPreferences.getBoolean("isAdmin",false)
        }

        fun getUserName(context: Context): String? {
            val sharedPreferences: SharedPreferences =context.getSharedPreferences(name,MODE)
            return sharedPreferences.getString("username","")
        }

        fun logOut(context: Context){
            val sharedPreferences: SharedPreferences =context.getSharedPreferences(name,MODE)
            val editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.remove("username")
            editor.remove("password")
            editor.remove("isAdmin")
            editor.apply()
        }

        fun  isLoggedIn(context: Context):Boolean{
            val sharedPreferences:SharedPreferences=context.getSharedPreferences(name,MODE)
            if(sharedPreferences.contains("username")){
                return true
            }
            return false
        }
}