package com.inter.trunks.demofestapp.login

import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.ui.BaseActivity
import com.inter.trunks.demofestapp.base.ui.fragment.BaseFragment
import com.inter.trunks.demofestapp.registration.REGISTRATION_STATE_PATH
import com.inter.trunks.demofestapp.registration.RegistrationState
import kotlinx.android.synthetic.main.fragment_login.*
import me.ilich.juggler.change.Add
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel

open class LoginFragment : BaseFragment() {

    override fun getLayoutResources(): Int = R.layout.fragment_login

    val vm: LoginVM by viewModel()

    override fun initialize() {
        sign_up.setOnClickListener {
            navigateTo().state(
                Add.newActivity(
                    get(name = REGISTRATION_STATE_PATH) as RegistrationState,
                    BaseActivity::class.java
                )
            )
        }

        sign_in.setOnClickListener {
            vm
        }
    }
}