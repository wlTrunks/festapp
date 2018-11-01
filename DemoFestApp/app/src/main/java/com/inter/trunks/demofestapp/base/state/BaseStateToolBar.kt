package com.inter.trunks.demofestapp.base.state

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.ui.fragment.CommonToolbarFragment
import me.ilich.juggler.gui.JugglerFragment
import me.ilich.juggler.states.ContentBelowToolbarState
import me.ilich.juggler.states.State
import org.koin.standalone.KoinComponent


abstract class BaseStateToolBar(params: Params?) : ContentBelowToolbarState<State.Params>(params), KoinComponent {
    override fun onConvertToolbar(params: Params?, fragment: JugglerFragment?) =
        CommonToolbarFragment.createBack()

    override fun getUpNavigationIcon(context: Context?, params: Params?) =
        ContextCompat.getDrawable(context!!, R.drawable.ic_back_arrow)!!

    override fun getToolbarDisplayOptions(): Int {
        return ActionBar.DISPLAY_SHOW_TITLE or ActionBar.DISPLAY_HOME_AS_UP
    }
}