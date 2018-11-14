package com.inter.trunks.demofestapp.calendar.model

data class Days(val dayMonth: Int, val dayTitle: String, val eventList: MutableList<String>) : CalendarItemType {
    override fun getType(): Int = 1
}