package com.inter.trunks.demofestapp.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inter.trunks.demofestapp.base.interfaces.LayoutResources
import me.ilich.juggler.gui.JugglerFragment

abstract class BaseFragment : JugglerFragment(), LayoutResources {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResources(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    abstract fun initialize()
}