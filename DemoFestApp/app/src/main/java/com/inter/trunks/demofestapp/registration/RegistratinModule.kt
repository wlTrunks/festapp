package com.inter.trunks.demofestapp.registration

import com.inter.trunks.demofestapp.base.util.AppSharedPreferences
import com.inter.trunks.demofestapp.registration.repository.LocalRegRepository
import com.inter.trunks.demofestapp.registration.repository.RegInterefaceRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module


const val REGISTRATION_FRAGMENT_PATH_MODULE: String = "fest.registration"
const val REGISTRATION_FRAGMENT_PATH: String = "fest.registration.fragment"
const val REGISTRATION_STATE_PATH: String = "fest.state.fragment"
const val REGISTRATION_SHARED_PREF: String = "fest.preferences"
const val REGISTRATION_REPOSITORY_LOCAL: String = "fest.repository.local"

val RegistrationModule: Module = module(override = true, path = REGISTRATION_FRAGMENT_PATH_MODULE) {
    single(name = REGISTRATION_FRAGMENT_PATH) { RegistrationFragment() }
    single(name = REGISTRATION_STATE_PATH) { RegistrationState() }
    single(name = REGISTRATION_SHARED_PREF) { AppSharedPreferences(androidApplication(), REGISTRATION_SHARED_PREF) }
    single(name = REGISTRATION_REPOSITORY_LOCAL) { LocalRegRepository() as RegInterefaceRepository }
    viewModel { RegistrationVM() }
}