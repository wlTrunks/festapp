package com.inter.trunks.demofestapp.login

import org.koin.dsl.module.Module
import org.koin.dsl.module.module

const val LOGIN_PATH_MODULE: String = "fest.login"
const val LOGIN_FRAGMENT_PATH_MODULE: String = "fest.login.fragment"

val LoginModule: Module = module(override = true, path = LOGIN_PATH_MODULE) {

    single(name = LOGIN_FRAGMENT_PATH_MODULE) { LoginFragment() }
}