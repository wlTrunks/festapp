package com.inter.trunks.demofestapp

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.inter.trunks.demofestapp.app.di.AppModule
import com.inter.trunks.demofestapp.app.di.MainModule
import com.inter.trunks.demofestapp.event.di.EventModule
import com.inter.trunks.demofestapp.login.LoginModule
import com.inter.trunks.demofestapp.map.di.MapModule
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
            RegistrationModule,
            MainModule,
            EventModule,
            MapModule
        )
        startKoin(this, koinList)
    }
}