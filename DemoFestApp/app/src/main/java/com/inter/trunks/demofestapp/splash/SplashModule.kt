package com.inter.trunks.demofestapp.splash

import android.os.Handler
import com.inter.trunks.demofestapp.login.LoginState
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val SplashModule: Module = module(override = true) {
    factory { Handler() }
    single { LoginState() }
}