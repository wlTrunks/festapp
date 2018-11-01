package com.inter.trunks.demofestapp.splash

import android.os.Bundle
import android.os.Handler
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.ui.BaseActivity
import com.inter.trunks.demofestapp.login.LoginState
import me.ilich.juggler.change.Add
import me.ilich.juggler.change.Remove
import me.ilich.juggler.gui.JugglerActivity
import org.koin.android.ext.android.inject

class SplashActivity : JugglerActivity() {

    companion object {
        const val SPLASH_DELAY: Long = 1500
    }

    val mDelayHandler: Handler by inject()
    val loginState: LoginState by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mDelayHandler.postDelayed({
            onSplashShowingComplete()
        }, SPLASH_DELAY)

    }

    fun onSplashShowingComplete() {
        navigateTo().state(
            Add.newActivity(
                loginState,
                BaseActivity::class.java
            )
        )
        navigateTo().state(Remove.closeCurrentActivity())
    }
}