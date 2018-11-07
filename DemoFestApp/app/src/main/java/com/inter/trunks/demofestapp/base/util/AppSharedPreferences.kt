package com.inter.trunks.demofestapp.base.util

import android.content.Context
import android.content.SharedPreferences

class AppSharedPreferences(val context: Context, val namePreferences: String) {

    fun getEditor(): SharedPreferences.Editor {
        return context.getSharedPreferences(namePreferences, Context.MODE_PRIVATE).edit()
    }

    fun <T : Any> putData(data: T, namePreferences: String): Boolean {
        val editor = getEditor()
        when (data) {
            is String -> editor.putString(namePreferences, data as String)
            is Int -> editor.putInt(namePreferences, data as Int)
            is Boolean -> editor.putBoolean(namePreferences, data as Boolean)
            is Long -> editor.putLong(namePreferences, data as Long)
            is Float -> editor.putFloat(namePreferences, data as Float)
            is MutableList<*> -> editor.putStringSet(namePreferences, data as MutableSet<String>?)
        }
        return editor.commit()
    }

    fun <T> getData(data: T, namePreferences: String): Any {
        val shared = context.getSharedPreferences(namePreferences, Context.MODE_PRIVATE)
        when (data) {
            is String -> return shared.getString(namePreferences, "")
            is Int -> return shared.getInt(namePreferences, -1)
            is Boolean -> return shared.getBoolean(namePreferences, false)
            is Long -> return shared.getLong(namePreferences, -1)
            is Float -> return shared.getFloat(namePreferences, 0.0f)
            is MutableList<*> -> return shared.getStringSet(namePreferences, mutableSetOf<String>())
            else -> return Unit
        }
    }

    fun getData(namePreferences: String): String {
        val shared = context.getSharedPreferences(namePreferences, Context.MODE_PRIVATE)
        return shared.getString(namePreferences, "")
    }
}