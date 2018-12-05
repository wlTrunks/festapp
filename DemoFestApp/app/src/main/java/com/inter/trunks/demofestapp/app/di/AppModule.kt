package com.inter.trunks.demofestapp.app.di

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

const val APP_MODULE: String = "app_module"
const val COMPOSITE_DISPOSABLE: String = "app_module_compositedisposable"

val AppModule: Module = module(path = APP_MODULE) {
    factory(name = COMPOSITE_DISPOSABLE) { CompositeDisposable() }
}