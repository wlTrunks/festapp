package com.inter.trunks.demofestapp.login

import com.inter.trunks.demofestapp.base.util.AppSharedPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

const val LOGIN_PATH_MODULE: String = "login"
const val LOGIN_FRAGMENT_PATH: String = "login.fragment"
const val LOGIN_SHARED_PREF: String = "login.preferences"

val LoginModule: Module = module(override = true, path = LOGIN_PATH_MODULE) {

    single(name = LOGIN_FRAGMENT_PATH) { LoginFragment() }
    viewModel { LoginVM() }
    single(name = LOGIN_SHARED_PREF) { AppSharedPreferences(androidApplication(), LOGIN_SHARED_PREF) }
}