package com.inter.trunks.demofestapp.login

import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.ui.fragment.BaseFragment
import com.inter.trunks.demofestapp.base.addFragment
import com.inter.trunks.demofestapp.registration.RegistrationFragment
import kotlinx.android.synthetic.main.fragment_login.*

open class LoginFragment : BaseFragment() {

    override fun getLayoutResources(): Int = R.layout.fragment_login

    override fun initialize() {
        register.setOnClickListener {
        }
    }
}