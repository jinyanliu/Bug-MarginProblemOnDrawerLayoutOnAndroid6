package com.example.marginproblemonandroid6

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.drawer_layout
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawer_open, R.string.drawer_close)
        drawer_layout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SearchFragment()).commit()
        nav_view.setCheckedItem(R.id.search)

        nav_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SearchFragment()).commit()
                R.id.gallery -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, GalleryFragment()).commit()
                R.id.call -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CallFragment()).commit()
                R.id.share -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ShareFragment()).commit()
                R.id.send -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SendFragment()).commit()
                R.id.close -> finish()
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }

        val callMenuItem = nav_view.menu.findItem(R.id.call)
        // Here you can see the margin problem on Android 6: the top margin is not showing on Android 6 devices, but shows on others.
        callMenuItem.setActionView(R.layout.call_text)

        // Here you can see the margin problem on Android 6: the start margin is not showing on Android 6 devices, but shows on others.
        val navigationHeaderView = layoutInflater.inflate(R.layout.drawer_header_view,nav_view,false)
        nav_view.addHeaderView(navigationHeaderView)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) drawer_layout.closeDrawer(GravityCompat.START) else super.onBackPressed()
    }
}
