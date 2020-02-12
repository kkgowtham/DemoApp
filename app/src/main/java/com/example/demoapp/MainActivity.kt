package com.example.demoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mUserName=findViewById<EditText>(R.id.editText)
        var mPassword:EditText=findViewById(R.id.editText2)
        var mButton:Button=findViewById(R.id.submit_button)

        mUserName.setText("admin")
        mPassword.setText("admin")
        mButton.setOnClickListener {
            var a:String=mUserName.text.toString()
            var b:String=mPassword.text.toString()

            if(a.isNotEmpty() && b.isNotEmpty()){
                if (a == b && a == "admin"){
                    SessionManager.save(applicationContext,a,b,true)
                }else if (a == b){
                    SessionManager.save(applicationContext,a,b,false)
                }
                val intent = Intent(this,HomeActivity::class.java)
                //intent.putExtra("isAdmin",false)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Invalid user or password",Toast.LENGTH_LONG).show()
            }
        }
    }
}
