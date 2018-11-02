package com.inter.trunks.demofestapp.app

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

const val APP_MODULE: String = "app_module"

val AppModule: Module = module(path = APP_MODULE) {
    single { CompositeDisposable() }
}