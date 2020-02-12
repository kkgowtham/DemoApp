package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.example.demoapp.model.CartProduct
import com.example.demoapp.viewmodel.CartViewModel
import com.example.demoapp.viewmodel.ProductViewModel

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ProductActivity : AppCompatActivity() {

    lateinit var imageView:ImageView
    lateinit var nameTextView: TextView
    lateinit var priceTextView: TextView
    lateinit var quantityTextView: TextView
    lateinit var decreaseButton: ImageButton
    lateinit var increaseButton: ImageButton
    lateinit var addtocartButton: Button


    lateinit var category: String
    lateinit var id:String
     var quantity:Int=1

    lateinit var imageurl:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        initializeViews()

        imageurl=intent.getStringExtra("imageurl")
        Glide.with(applicationContext).load(imageurl).into(imageView)
        nameTextView.text=intent.getStringExtra("name")
        priceTextView.text=intent.getStringExtra("price")
        category=intent.getStringExtra("category")
        id=intent.getStringExtra("id")


        decreaseButton.isEnabled=false
        decreaseButton.setOnClickListener {
            quantity--
            quantityTextView.text=quantity.toString()
            if(quantity==1)
            {
                decreaseButton.isEnabled=false
            }
        }
        increaseButton.setOnClickListener {
            quantity++
            quantityTextView.text = quantity.toString()
            if(quantity>1)
            {
                decreaseButton.isEnabled=true
            }
        }

        addtocartButton.setOnClickListener {
            var cartProduct = CartProduct()
            cartProduct.category=category
            cartProduct.pId=id
            cartProduct.pImageUrl=imageurl
            cartProduct.price=priceTextView.text.toString().toDouble()
            cartProduct.quantity=quantity
            cartProduct.pName=nameTextView.text.toString()
            cartProduct.userid= SessionManager.getUserName(applicationContext).toString()
            val viewModel= CartViewModel(application,applicationContext)
            viewModel.add(cartProduct)
            Toast.makeText(applicationContext,"Added To Cart",Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun initializeViews(){
        imageView=findViewById(R.id.image_product)
        nameTextView=findViewById(R.id.product_name_tv)
        priceTextView=findViewById(R.id.product_price_tv)
        quantityTextView=findViewById(R.id.quantity_tv)
        decreaseButton=findViewById(R.id.decrease_button)
        increaseButton=findViewById(R.id.increase_button)
        addtocartButton=findViewById(R.id.add_to_cart_button)
    }
}
