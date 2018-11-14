package com.inter.trunks.demofestapp.event

import org.koin.dsl.module.Module
import org.koin.dsl.module.module

const val EVENT_MODULE: String = "event"
const val EVENT_PAGER_LIST: String = "event_pager_list"
val EventModule: Module = module(path = EVENT_MODULE) {
    single(name = EVENT_PAGER_LIST) {
        mutableMapOf(
            Pair("Основные События", LineUpFragment()),
            Pair("Избранные События", LineUpFragment()),
            Pair("Поиск Событий", LineUpFragment())
        )
    }
}