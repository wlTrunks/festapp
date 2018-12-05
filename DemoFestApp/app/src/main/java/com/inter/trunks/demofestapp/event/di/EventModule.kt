package com.inter.trunks.demofestapp.event.di

import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.event.LineUpFragment
import com.inter.trunks.demofestapp.event.SearchInEventFragment
import com.inter.trunks.demofestapp.event.model.EventItemLiveData
import com.inter.trunks.demofestapp.event.repository.LineUpInterface
import com.inter.trunks.demofestapp.event.repository.MockLineUp
import com.inter.trunks.demofestapp.event.vm.LineUpVM
import com.inter.trunks.demofestapp.event.vm.SearchInEventVM
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

const val EVENT_MODULE: String = "event"
const val EVENT_PAGER_LIST: String = "event_pager_list"
const val EVENT_LINE_UP_VM: String = "event_line_up_vm"
const val EVENT_SEARCH_LINE_UP_VM: String = "event_search_line_up_vm"
const val EVENT_ITEM_LD: String = "event_item_lv"
const val EVENT_ITEM_ADAPTER: String = "event_item_EVENT_ITEM_ADAPTER"
val EventModule: Module = module(path = EVENT_MODULE) {
    single(name = EVENT_PAGER_LIST) {
        mutableMapOf(
            Pair(androidContext().getString(R.string.event_main), LineUpFragment.instance(false)),
            Pair(androidContext().getString(R.string.event_favorite), LineUpFragment.instance(true)),
            Pair(androidContext().getString(R.string.event_search), SearchInEventFragment())
        )
    }
    viewModel(name = EVENT_LINE_UP_VM) { LineUpVM() }
    viewModel(name = EVENT_SEARCH_LINE_UP_VM) { SearchInEventVM() }
    single { MockLineUp() as LineUpInterface }
    single(name = EVENT_ITEM_LD) { EventItemLiveData() }
}