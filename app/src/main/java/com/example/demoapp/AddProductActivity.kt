package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_product.*
import com.example.demoapp.model.Product
import com.example.demoapp.utils.Utils
import com.example.demoapp.viewmodel.ProductViewModel


class AddProductActivity : AppCompatActivity() {

   lateinit var nameEditText:EditText
   private lateinit var priceEditText:EditText
    private lateinit var imageUrlEditText: EditText
    lateinit var category:String
    lateinit var url:String
    var TAG=javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        initializeViews()
        category= Utils.category
        Log.d(TAG,category)
        add_product_button.setOnClickListener{
            if(TextUtils.isEmpty(nameEditText.text))
            {
                nameEditText.error = "Product Name cannot be empty"
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(nameEditText.text))
            {
                priceEditText.error = "Price cannot be empty"
            }
            add()
        }
    }

    fun initializeViews(){
        nameEditText=findViewById(R.id.product_name_edittext)
        priceEditText=findViewById(R.id.product_price_edittext)
        imageUrlEditText=findViewById(R.id.image_url_edit_text)
        url= Utils.getImageUrl()
        imageUrlEditText.setText(url)
    }

    fun add(){
        val mProductName=nameEditText.text.toString()
        val mProductPrice=priceEditText.text.toString()

        val product= Product()
        product.pName=mProductName
        product.price=mProductPrice.toDouble()
        product.pImageUrl=url
        product.category= category
        Utils.category=category
        val viewModel=ProductViewModel(application)
        viewModel.add(product)
        Toast.makeText(applicationContext,"Product Added",Toast.LENGTH_LONG).show()
        finish()
    }

}
