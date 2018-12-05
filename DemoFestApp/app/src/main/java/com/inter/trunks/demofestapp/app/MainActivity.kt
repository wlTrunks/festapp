package com.inter.trunks.demofestapp.app

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.app.di.*
import com.inter.trunks.demofestapp.base.replaceFragment
import com.inter.trunks.demofestapp.base.ui.BaseActivity
import com.inter.trunks.demofestapp.calendar.CalendarEventFragment
import com.inter.trunks.demofestapp.event.EventPagerFragment
import com.inter.trunks.demofestapp.event.SearchInEventFragment
import com.inter.trunks.demofestapp.event.di.EVENT_SEARCH_LINE_UP_VM
import com.inter.trunks.demofestapp.map.MapFragment
import com.inter.trunks.demofestapp.profile.ProfileFragment
import com.inter.trunks.demofestapp.search.SearchEventFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {
    val calendarEventFragment: CalendarEventFragment by inject(name = MAIN_CALENDAR_EVENT_FRAGMENT)
    val eventPagerFragment: EventPagerFragment by inject(name = MAIN_EVENT_FRAGMENT)
    val mapFragment: MapFragment by inject(name = MAIN_MAP_FRAGMENT)
    val searchFragment: SearchEventFragment by inject(name = MAIN_SEARCH_FRAGMENT)
    val profileFragment: ProfileFragment by inject(name = MAIN_PROFILE_FRAGMENT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNavigationButtonsListener()

        replaceFragment(calendarEventFragment, R.id.fragment_container)
    }

    fun setNavigationButtonsListener() {
        bottom_navigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var fr: Fragment? = null
                when (item.itemId) {
                    R.id.ic_calendar -> fr = calendarEventFragment
                    R.id.ic_lineup -> fr = eventPagerFragment
                    R.id.ic_place -> fr = mapFragment
                    R.id.ic_search -> fr = searchFragment
                    R.id.ic_profile -> fr = profileFragment
                }
                replaceFragment(fr!!, R.id.fragment_container)
                return true
            }
        })
    }
}
