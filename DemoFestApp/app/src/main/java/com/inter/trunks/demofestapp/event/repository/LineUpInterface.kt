package com.inter.trunks.demofestapp.event.repository

import com.inter.trunks.demofestapp.event.model.EventItem

interface LineUpInterface {
    fun getLineUpList(): MutableList<EventItem>
}