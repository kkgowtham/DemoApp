package com.example.demoapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.demoapp.utils.Utils
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView


class HomeActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerLayout:DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var imageview:CircleImageView
    lateinit var tv1:TextView
    private var isAdmin: Boolean? =null

    lateinit var fab:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        isAdmin= SessionManager.isAdmin(this)
        initializeViews()
        isLoggedIn()
        setUpFragment()

    }

    @SuppressLint("DefaultLocale")
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        if(menuItem.itemId==R.id.logout_btn)
        {
            SessionManager.logOut(this)
            val intent=Intent(this,HomeActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
        val fragment:Fragment=AdminFragment()
        val bundle = Bundle()
        bundle.putString("category",menuItem.title.toString())
        fragment.arguments=bundle
        Utils.category=menuItem.title.toString().toLowerCase()
        supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()
        drawerLayout.closeDrawer(Gravity.LEFT)
        return true
    }

    fun setUpFragment()
    {
        Glide.with(applicationContext).load("https://i.ya-webdesign.com/images/avatar-png-1.png").into(imageview)
        tv1.text = SessionManager.getUserName(this)
        val fragment:Fragment
        val bundle=Bundle()
        bundle.putString("category","books")
        Utils.category="books"
        if(this.isAdmin!!){
            fragment=AdminFragment()
            fragment.arguments=bundle
            supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()
        }else{
            fragment=UserFragment()
            fragment.arguments=bundle
            supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()
        }
    }

    fun initializeViews(){
        val toolbar: Toolbar =findViewById(R.id.toolbar)
        fab=findViewById(R.id.fab_goto_cart)
        fab.setOnClickListener{
            startActivity(Intent(this,CartActivity::class.java))
        }
        drawerLayout=findViewById(R.id.drawer_layout)
        navigationView=findViewById(R.id.nav_view)
        val view: View =navigationView.getHeaderView(0)
        tv1=view.findViewById(R.id.name)
        imageview=view.findViewById(R.id.profile_image)
        setSupportActionBar(toolbar)
        val lisetener = ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0)
        drawerLayout.addDrawerListener(lisetener)
        lisetener.syncState()
        navigationView.setNavigationItemSelectedListener(this)
    }

    fun isLoggedIn(){
        if(!SessionManager.isLoggedIn(this)){
           startActivity(Intent(this,MainActivity::class.java))
        }
    }

}
