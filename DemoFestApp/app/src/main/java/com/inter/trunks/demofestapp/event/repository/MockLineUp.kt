package com.inter.trunks.demofestapp.event.repository

import com.inter.trunks.demofestapp.event.model.EventItem

class MockLineUp : LineUpInterface {
    var list: MutableList<EventItem>

    init {
        list = mutableListOf(
            EventItem(1, 0, "Открытие", "10:00", false),
            EventItem(2, 1, "Главная сцена", "11:00", false),
            EventItem(3, 2, "Представление", "12:00", true),
            EventItem(4, 3, "Выход ведущих", "12:30", true),
            EventItem(5, 4, "Начало чемпионата", "15:00", false),
            EventItem(6, 5, "ПолуФинал", "16:00", false),
            EventItem(7, 6, "Финал", "17:00", false),
            EventItem(8, 7, "Закрытие", "18:00", false)
        )
    }

    override fun getLineUpList(): MutableList<EventItem> = list

}