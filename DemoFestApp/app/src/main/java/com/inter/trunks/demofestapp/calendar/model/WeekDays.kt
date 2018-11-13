package com.inter.trunks.demofestapp.calendar.model

data class WeekDays(val days: Int, val dayTitle: String) : CalendarItemType {
    override fun getType(): Int = 2
}