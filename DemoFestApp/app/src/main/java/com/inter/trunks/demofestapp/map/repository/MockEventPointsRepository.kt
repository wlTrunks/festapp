package com.inter.trunks.demofestapp.map.repository

import com.inter.trunks.demofestapp.map.model.EventPoint

class MockEventPointsRepository : GetEventPoints {
    override fun loadEventPoint(uuid: Int): MutableList<EventPoint> {
        return mutableListOf(
            EventPoint(1, 2, "Главная сцена", 55.795190, 37.675425),
            EventPoint(2, 2, "Ярмарка", 55.795922, 37.679419),
            EventPoint(3, 2, "Выставка", 55.793440, 37.674685),
            EventPoint(4, 2, "Танцевальный зал", 55.795700, 37.674506)
        )
    }
}