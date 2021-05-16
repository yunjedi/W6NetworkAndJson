package com.test.networkandjson.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.test.networkandjson.fragment.NowPlayingFragment
import com.test.networkandjson.fragment.TopRatedFragment


class ViewPager2Adapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NowPlayingFragment()
            1 -> TopRatedFragment()
            else -> NowPlayingFragment()
        }
    }
}

