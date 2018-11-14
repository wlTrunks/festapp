package com.inter.trunks.demofestapp.event

import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.ui.fragment.BaseFragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_event_pager.*
import com.google.android.material.tabs.TabLayout
import com.inter.trunks.demofestapp.event.adapter.EventAdapter


class EventPagerFragment : BaseFragment() {
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout
    override fun initialize() {
        viewPager = view_pager
        tabLayout = tab_layout
        setViewPager()
    }

    private fun setViewPager() {
        viewPager.adapter = EventAdapter(fragmentManager!!)
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun getLayoutResources(): Int = R.layout.fragment_event_pager


}