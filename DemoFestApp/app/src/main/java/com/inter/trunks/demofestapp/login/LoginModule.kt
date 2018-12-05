package com.inter.trunks.demofestapp.login

import com.inter.trunks.demofestapp.base.util.AppSharedPreferences
import com.inter.trunks.demofestapp.login.repository.LocalLoginRepository
import com.inter.trunks.demofestapp.login.repository.LoginInterefaceRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

const val LOGIN_PATH_MODULE: String = "login"
const val LOGIN_FRAGMENT_PATH: String = "login.fragment"
const val LOGIN_SHARED_PREF: String = "login.preferences"
const val LOGIN_REPOSITORY_LOCAL: String = "login.repository.local"

val LoginModule: Module = module(override = true, path = LOGIN_PATH_MODULE) {
    single(name = LOGIN_FRAGMENT_PATH) { LoginFragment() }
    single(name = LOGIN_REPOSITORY_LOCAL){LocalLoginRepository() as LoginInterefaceRepository}
    viewModel { LoginVM() }
    single(name = LOGIN_SHARED_PREF) { AppSharedPreferences(androidContext(), LOGIN_SHARED_PREF) }
}