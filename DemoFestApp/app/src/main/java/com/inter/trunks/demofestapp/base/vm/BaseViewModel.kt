package com.inter.trunks.demofestapp.base.vm

import android.arch.lifecycle.*
import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

abstract class BaseViewModel : ViewModel(), LifecycleObserver, KoinComponent {

    val disposables: CompositeDisposable by inject()

    fun launch(job: () -> Disposable) {
        disposables.add(job())
    }

    /**
     * Реализовываем метод для подписчиков жизненного цикла.
     */
    open fun subscribeTo(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun destroy() {
        disposables.clear()
    }

    /**
     * Не знаю, нужен ли теперь данный метод, ведь тоже самое делает теперь реализация Lifecycle.
     */
    @CallSuper
    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}