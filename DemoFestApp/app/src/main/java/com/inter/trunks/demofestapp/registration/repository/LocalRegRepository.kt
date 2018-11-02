package com.inter.trunks.demofestapp.registration.repository

import com.inter.trunks.demofestapp.base.util.AppSharedPreferences
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class LocalRegRepository : RegInterefaceRepository, KoinComponent {
    val LOGIN_SHARED_PREF = "login_shared_pref"
    val appSharedPreferences: AppSharedPreferences by inject()
    override fun saveUser(login: String, pass: String): Int {
        if (appSharedPreferences.putData(String, LOGIN_SHARED_PREF)
            && appSharedPreferences.putData(String, LOGIN_SHARED_PREF)
        ) return 0
        return -1
    }

}