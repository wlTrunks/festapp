package com.inter.trunks.demofestapp.event.model

data class EventItem(val uuid: Int, val order: Int, val title: String, val beginTime: String, var isChecked: Boolean)