package com.inter.trunks.demofestapp.app

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.replaceFragment
import com.inter.trunks.demofestapp.base.ui.BaseActivity
import com.inter.trunks.demofestapp.calendar.CalendarEventFragment
import com.inter.trunks.demofestapp.event.EventPagerFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {
    val calendarEventFragment: CalendarEventFragment by inject(name = MAIN_CALENDAR_EVENT_FRAGMENT)
    val eventPagerFragment: EventPagerFragment by inject(name = MAIN_EVENT_FRAGMENT)
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
                }
                replaceFragment(fr!!, R.id.fragment_container)
                return true
            }
        })
    }
}
