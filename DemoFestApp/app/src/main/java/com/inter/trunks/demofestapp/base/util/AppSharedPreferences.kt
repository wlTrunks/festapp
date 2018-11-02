package com.inter.trunks.demofestapp.base.util

import android.content.Context
import android.content.SharedPreferences

class AppSharedPreferences(val context: Context, val namePreferences: String) {

    fun getEditor(): SharedPreferences.Editor {
        return context.getSharedPreferences(namePreferences, Context.MODE_PRIVATE).edit()
    }

    fun <T : Any> putData(data: T, namePreferences: String): Boolean {
        val editor = getEditor()
        when {
            data is String -> editor.putString(namePreferences, data as String?)
            data is Int -> editor.putInt(namePreferences, data as Int)
            data is Boolean -> editor.putBoolean(namePreferences, data as Boolean)
            data is Long -> editor.putLong(namePreferences, data as Long)
            data is Float -> editor.putFloat(namePreferences, data as Float)
            data is MutableList<*> -> editor.putStringSet(namePreferences, data as MutableSet<String>?)
        }
        return editor.commit()
    }

    fun getData(dataType: Any, namePreferences: String): Any {
        val shared = context.getSharedPreferences(namePreferences, Context.MODE_PRIVATE)
        when {
            dataType is String -> return shared.getString(namePreferences, "")
            dataType is Int -> return shared.getInt(namePreferences, -1)
            dataType is Boolean -> return shared.getBoolean(namePreferences, false)
            dataType is Long -> return shared.getLong(namePreferences, -1)
            dataType is Float -> return shared.getFloat(namePreferences, 0.0f)
            dataType is MutableList<*> -> return shared.getStringSet(namePreferences, mutableSetOf<String>())
            else -> return Unit
        }
    }
}