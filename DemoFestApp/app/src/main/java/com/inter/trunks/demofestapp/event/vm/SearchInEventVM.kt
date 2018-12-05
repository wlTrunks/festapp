package com.inter.trunks.demofestapp.event.vm

import com.inter.trunks.demofestapp.base.util.LogUtil
import com.inter.trunks.demofestapp.event.model.EventItem
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class SearchInEventVM : LineUpVM() {

    fun instantSearch(subject: PublishSubject<String>, listFinded: (MutableList<EventItem>) -> Unit) {
        launch {
            subject
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .filter(object : Predicate<String> {
                    override fun test(t: String): Boolean {
                        return t.length > 1
                    }

                })
                .switchMap(object : Function<String, ObservableSource<MutableList<EventItem>>> {
                    override fun apply(t: String): ObservableSource<MutableList<EventItem>> {
                        LogUtil.printLog("SearchInEventVM", "filter t $t")
                        return getFilteredList(t)
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Consumer<MutableList<EventItem>> {
                    override fun accept(t: MutableList<EventItem>) {
                        LogUtil.printLog("SearchInEventVM", "final list.size " + t.size)
                        for (item in t) {
                            LogUtil.printLog("SearchInEventVM", "final item " + item.title)
                        }
                        listFinded.invoke(t)
                    }
                })
        }
    }

    fun getFilteredList(searchTerm: String): ObservableSource<MutableList<EventItem>> {
        return Observable.fromIterable(repository.getLineUpList())
            .filter(object : Predicate<EventItem> {
                override fun test(t: EventItem): Boolean {
                    LogUtil.printLog("SearchInEventVM", "searchTerm $searchTerm")
                    LogUtil.printLog("SearchInEventVM", "t title " + t.title)
                    LogUtil.printLog(
                        "SearchInEventVM",
                        " t.title.startsWith(searchTerm) " + t.title.startsWith(searchTerm, true)
                    )
                    return t.title.startsWith(searchTerm, true)
                }
            })
            .toList()
            .toObservable()
    }
}

