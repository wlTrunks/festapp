package com.inter.trunks.demofestapp.calendar.model

data class Days(val days: Int, val dayTitle: String) : CalendarItemType {
    override fun getType(): Int = 1
}