package com.inter.trunks.demofestapp.login.repository

import android.text.TextUtils
import com.inter.trunks.demofestapp.base.util.AppSharedPreferences
import com.inter.trunks.demofestapp.base.util.LogUtil
import com.inter.trunks.demofestapp.registration.REGISTRATION_SHARED_PREF
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class LocalLoginRepository : LoginInterefaceRepository, KoinComponent {
    val LOGIN_SHARED_PREF = "login_shared_pref"
    val PASS_SHARED_PREF = "pass_shared_pref"
    val appSharedPreferences: AppSharedPreferences by inject(name = REGISTRATION_SHARED_PREF)
    override fun singIn(login: String, pass: String): Int {
        val savedlogin :String = appSharedPreferences.getData(LOGIN_SHARED_PREF)
        LogUtil.printLog("LocalLoginRepository", " savedlogin = $savedlogin ")
        if (!TextUtils.isEmpty(savedlogin)) {
            val valuePass: String = appSharedPreferences.getData( PASS_SHARED_PREF)
            LogUtil.printLog("LocalLoginRepository", "valuePass  = $valuePass ")
            if (pass == valuePass) return 0
        }
        return -1
    }

}