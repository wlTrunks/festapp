package com.inter.trunks.demofestapp.login

import android.content.Context
import com.inter.trunks.demofestapp.base.util.LogUtil
import com.inter.trunks.demofestapp.base.vm.BaseViewModel
import com.inter.trunks.demofestapp.login.repository.LoginInterefaceRepository
import org.koin.standalone.inject

class LoginVM : BaseViewModel() {
    val repository: LoginInterefaceRepository by inject(name = LOGIN_REPOSITORY_LOCAL)
    fun signUp(
        context: Context,
        login: String,
        pass: String,
        onResult: (() -> Unit),
        onFail: (() -> Unit)
    ) {
        val code = repository.singIn(login, pass)
        LogUtil.printLog("LoginVM", "singn code = $code ")
        when (code) {
            0 -> onResult.invoke()
            -1 -> onFail.invoke()
        }

    }
}