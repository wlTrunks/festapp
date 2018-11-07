package com.inter.trunks.demofestapp

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.inter.trunks.demofestapp.app.AppModule
import com.inter.trunks.demofestapp.login.LoginModule
import com.inter.trunks.demofestapp.registration.RegistrationModule
import com.inter.trunks.demofestapp.splash.SplashModule
import org.koin.android.ext.android.startKoin

class DemoFestApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        val koinList = arrayListOf(
            AppModule,
            SplashModule,
            LoginModule,
            RegistrationModule
        )
        startKoin(this, koinList)
    }
}