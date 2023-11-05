package com.example.shakemate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shakemate.databinding.ActivityMainBinding
import com.example.shakemate.networking.ApiModule
import com.example.shakemate.ui.myCocktails.CocktailList
import com.example.shakemate.ui.searchCocktails.SearchFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, SearchFragment()).commit()
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.search_nav -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, SearchFragment()).commit()
                    true
                }
                R.id.my_cocktails_nav -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, CocktailList()).commit()
                    true
                }
                else -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, SearchFragment()).commit()
                    true
                }
        }
        }

        ApiModule.initRetrofit(this)
        setContentView(binding.root)
    }
}