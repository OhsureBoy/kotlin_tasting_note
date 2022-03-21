package com.study.tastingnote.ui.liquor

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.study.tastingnote.R
import com.study.tastingnote.databinding.ActivityMainBinding
import com.study.tastingnote.ui.liquor.fragment.LiquorFragment
import com.study.tastingnote.ui.liquor.fragment.LiquorWriteListFragment

class MainActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)

        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.viewPager.registerOnPageChangeCallback(ViewPagerPageChangeCallback())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.page_liquor -> {
                binding.viewPager.currentItem = 0
                return true
            }
            R.id.page_liquor_list-> {
                binding.viewPager.currentItem = 1
                return true
            }
        }
        return false
    }

    private inner class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {

            return when (position) {
                0-> LiquorFragment()
                1-> LiquorWriteListFragment()
                else -> error("No Fragment")
            }
        }
    }

    private inner class ViewPagerPageChangeCallback : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {

            binding.bottomNavigationView.selectedItemId = when(position) {
                0 -> R.id.page_liquor
                1 -> R.id.page_liquor_list
                else -> error("No id")
            }
        }
    }
}