package com.inter.trunks.demofestapp.map.repository

import com.inter.trunks.demofestapp.map.model.EventPoint

interface GetEventPoints {
    fun loadEventPoint(uuid: Int): List<EventPoint>
}