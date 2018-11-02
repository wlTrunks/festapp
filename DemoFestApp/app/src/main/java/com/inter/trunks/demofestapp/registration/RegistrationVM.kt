package com.inter.trunks.demofestapp.registration

import com.inter.trunks.demofestapp.base.util.LogUtil
import com.inter.trunks.demofestapp.base.vm.BaseViewModel
import com.inter.trunks.demofestapp.registration.repository.RegInterefaceRepository
import org.koin.standalone.inject

class RegistrationVM : BaseViewModel() {
    val localRegRepository: RegInterefaceRepository by inject(name = REGISTRATION_REPOSITORY_LOCAL)

    fun singUp(login: String, pass: String, repeatPass: String, onResult: (() -> Unit)? = null, onFail: (() -> Unit)) {
        LogUtil.printLog("RegistrationVM", "singUp")
        if (isPassEquals(pass, repeatPass)) {
            if (localRegRepository.saveUser(login, pass) != -1) onResult?.invoke()
        } else {
            onFail.invoke()
        }
    }


    fun isPassEquals(pass: String, repeatPass: String): Boolean = false
}