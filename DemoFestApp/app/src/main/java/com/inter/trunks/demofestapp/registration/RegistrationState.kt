package com.inter.trunks.demofestapp.registration

import android.content.Context
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.state.BaseStateToolBar
import me.ilich.juggler.gui.JugglerFragment
import me.ilich.juggler.states.VoidParams
import org.koin.standalone.get

class RegistrationState : BaseStateToolBar(VoidParams.instance()) {
    override fun onConvertContent(params: Params?, fragment: JugglerFragment?): JugglerFragment =
        get(name = REGISTRATION_FRAGMENT_PATH) as RegistrationFragment

    override fun getTitle(context: Context?, params: Params?): String? = context?.getString(R.string.sign_up)
}