package com.inter.trunks.demofestapp.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inter.trunks.demofestapp.app.di.COMPOSITE_DISPOSABLE
import com.inter.trunks.demofestapp.base.interfaces.LayoutResources
import io.reactivex.disposables.CompositeDisposable
import me.ilich.juggler.gui.JugglerFragment
import org.koin.android.ext.android.inject

abstract class BaseFragment : JugglerFragment(), LayoutResources {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResources(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    override fun onResume() {
        super.onResume()
    }

    abstract fun initialize()

    override fun onDestroy() {
        super.onDestroy()
    }
}