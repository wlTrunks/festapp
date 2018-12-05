package com.inter.trunks.demofestapp.event.adapter

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.inter.trunks.demofestapp.event.di.EVENT_PAGER_LIST
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class EventAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm), KoinComponent {
    val listFragment: MutableMap<String, Fragment> by inject(name = EVENT_PAGER_LIST)
    override fun getItem(position: Int): Fragment {
        return listFragment.get(getPageTitle(position))!!
    }

    fun addFragment(fragment: Fragment, title: String) {
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return listFragment.keys.elementAt(position)
    }

    override fun getCount(): Int = listFragment.size
}