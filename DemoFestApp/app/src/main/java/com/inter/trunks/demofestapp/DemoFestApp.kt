package com.inter.trunks.demofestapp

import android.support.multidex.MultiDexApplication
import android.support.v7.app.AppCompatDelegate
import com.inter.trunks.demofestapp.app.AppModule
import com.inter.trunks.demofestapp.login.LoginModule
import com.inter.trunks.demofestapp.splash.SplashModule
import org.koin.android.ext.android.startKoin

class DemoFestApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        val koinList = arrayListOf(
            AppModule,
            SplashModule,
            LoginModule
        )
        startKoin(this, koinList)
    }
}