package com.inter.trunks.demofestapp.base.rxeventbus

import android.annotation.SuppressLint
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

object RXEventBus {

    val bus = PublishSubject.create<Any>()

    fun send(event: Any) = bus.onNext(event)

    fun <T> listen(eventType: Class<T>): Flowable<T>? = bus.toFlowable(BackpressureStrategy.BUFFER).cast(eventType)

    fun <T> listenC(eventType: Class<T>, compositeDisposable: CompositeDisposable, proccess: (T) -> Unit) {
        val disposables: Disposable = bus.ofType(eventType)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                proccess.invoke(it)
            }
        compositeDisposable.add(disposables)

    }

    @SuppressLint("CheckResult")
    inline fun <reified T> process(crossinline action: (T) -> Unit, compositeDisposable: CompositeDisposable) {
        compositeDisposable.add(
            bus.subscribeOn(Schedulers.io())
                .filter { it is T }
                .map { it as T }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { action.invoke(it) }
        )
    }

    fun <T> listenO(eventType: Class<T>): Observable<T> = bus.ofType(eventType)
}