package com.inter.trunks.demofestapp.base.util

import android.util.Log
import com.inter.trunks.demofestapp.BuildConfig

object LogUtil {
    fun printLog(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, " $message")
        }
    }
}