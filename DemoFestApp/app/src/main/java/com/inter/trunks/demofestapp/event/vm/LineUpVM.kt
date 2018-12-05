package com.inter.trunks.demofestapp.event.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.inter.trunks.demofestapp.base.vm.BaseViewModel
import com.inter.trunks.demofestapp.event.di.EVENT_ITEM_LD
import com.inter.trunks.demofestapp.event.model.EventItem
import com.inter.trunks.demofestapp.event.model.EventItemLiveData
import com.inter.trunks.demofestapp.event.repository.LineUpInterface
import org.koin.standalone.inject

open class LineUpVM : BaseViewModel() {
    val repository: LineUpInterface by inject()
    val eventItemLiveData: EventItemLiveData by inject(name = EVENT_ITEM_LD)

    open fun load() {
        eventItemLiveData.postValue(repository.getLineUpList())
    }

    open fun getDumpList() = eventItemLiveData.value ?: repository.getLineUpList()

    open fun setObserverEventItemList(lifecycleOwner: LifecycleOwner, onDataChanged: (MutableList<EventItem>) -> Unit) {
        eventItemLiveData.observe(lifecycleOwner,
            Observer<MutableList<EventItem>> { t ->
                onDataChanged.invoke(t)
            })
    }
}