package com.hiepdt.vpstest.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

class MainPagerAdapter(fm: FragmentManager, private val mListFragment: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return mListFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return mListFragment[position]
    }
}