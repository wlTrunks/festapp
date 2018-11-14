package com.inter.trunks.demofestapp.app

import com.inter.trunks.demofestapp.calendar.CalendarEventFragment
import com.inter.trunks.demofestapp.event.EventPagerFragment
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

const val MAIN_MODULE: String = "main"
const val MAIN_EVENT_FRAGMENT: String = "main_event_fragment"
const val MAIN_CALENDAR_EVENT_FRAGMENT: String = "main_calendar_event_fragment"
val MainModule: Module = module(path = MAIN_MODULE) {
    single(name = MAIN_CALENDAR_EVENT_FRAGMENT) { CalendarEventFragment() }
    single(name = MAIN_EVENT_FRAGMENT) { EventPagerFragment() }
}