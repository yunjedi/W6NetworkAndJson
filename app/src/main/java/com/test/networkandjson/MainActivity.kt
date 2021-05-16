package com.test.networkandjson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.test.networkandjson.adapter.ViewPager2Adapter
import com.test.networkandjson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = ViewPager2Adapter(this)
        binding.viewPager.adapter = adapter

                binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                    override fun onPageSelected(position: Int) {
                        when(position){
                            0->binding.bottonNavigation.menu.findItem(R.id.navigation_nowplaying).setChecked(true)
                            1->{binding.bottonNavigation.menu.findItem(R.id.navigation_top).setChecked(true)
                            }
                            else-> {
                                0
                            }
                        }
                    }
                })
        binding.bottonNavigation.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.navigation_nowplaying -> binding.viewPager.setCurrentItem(0)
                R.id.navigation_top ->{
                    binding.viewPager.setCurrentItem(1)
                }

            }
        }
    }


}