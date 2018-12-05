package com.inter.trunks.demofestapp.app.di

import com.inter.trunks.demofestapp.calendar.CalendarEventFragment
import com.inter.trunks.demofestapp.event.EventPagerFragment
import com.inter.trunks.demofestapp.map.MapFragment
import com.inter.trunks.demofestapp.profile.ProfileFragment
import com.inter.trunks.demofestapp.search.SearchEventFragment
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

const val MAIN_MODULE: String = "main"
const val MAIN_EVENT_FRAGMENT: String = "main_event_fragment"
const val MAIN_CALENDAR_EVENT_FRAGMENT: String = "main_calendar_event_fragment"
const val MAIN_MAP_FRAGMENT: String = "main_map_fragment"
const val MAIN_SEARCH_FRAGMENT: String = "main_search_fragment"
const val MAIN_PROFILE_FRAGMENT: String = "main_profile_fragment"
val MainModule: Module = module(path = MAIN_MODULE) {
    single(name = MAIN_CALENDAR_EVENT_FRAGMENT) { CalendarEventFragment() }
    single(name = MAIN_EVENT_FRAGMENT) { EventPagerFragment() }
    single(name = MAIN_MAP_FRAGMENT) { MapFragment() }
    single(name = MAIN_SEARCH_FRAGMENT) { SearchEventFragment() }
    single(name = MAIN_PROFILE_FRAGMENT) { ProfileFragment() }
}