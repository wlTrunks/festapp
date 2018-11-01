package com.inter.trunks.demofestapp.app

import android.os.Bundle
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.addFragment
import com.inter.trunks.demofestapp.base.ui.BaseActivity
import com.inter.trunks.demofestapp.login.LoginFragment
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
