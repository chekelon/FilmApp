package com.openwebinars.filmapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.openwebinars.filmapp.R
import com.openwebinars.filmapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val newsFragment = NewFilmsFragment()
    private val favsFragment = FavsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        setFragment(newsFragment)

        setViewBottomNavigationListener()
    }

    private fun setFragment(fragmentToChange: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutFragmentHolder, fragmentToChange)
            .commit()
    }

    private fun setViewBottomNavigationListener() {
        //val viewBottomNav = findViewById<BottomNavigationView>(R.id.viewBottomNavigation)
        binding.viewBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.news -> setFragment(newsFragment)
                R.id.favs -> setFragment(favsFragment)
            }
            true
        }
    }
}