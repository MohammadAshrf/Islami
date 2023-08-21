package com.example.islami.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityHomeBinding
import com.example.islami.ui.home.tabs.hadeth.HadethFragment
import com.example.islami.ui.home.tabs.quran.QuranFragment
import com.example.islami.ui.home.tabs.radio.RadioFragment
import com.example.islami.ui.home.tabs.tasbeh.TasbehFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.content.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_quran -> {
                    showTabFragment(QuranFragment())
                }
                R.id.navigation_hadeth -> {
                    showTabFragment(HadethFragment())
                }
                R.id.navigation_radio -> {
                    showTabFragment(RadioFragment())
                }
                R.id.navigation_tasbeh -> {
                    showTabFragment(TasbehFragment())
                }
            }
            true
        }
        viewBinding.content.bottomNav.selectedItemId = R.id.navigation_quran
    }
            private fun showTabFragment(fragment: Fragment){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit()
            }
}