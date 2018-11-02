package com.inter.trunks.demofestapp.login

import com.inter.trunks.demofestapp.base.state.BaseState
import me.ilich.juggler.gui.JugglerFragment
import me.ilich.juggler.states.VoidParams
import org.koin.standalone.get

class LoginState : BaseState(VoidParams.instance()) {
    override fun onConvertContent(params: Params?, fragment: JugglerFragment?): JugglerFragment =
        get(name = LOGIN_FRAGMENT_PATH) as LoginFragment
}
