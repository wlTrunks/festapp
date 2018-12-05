package com.inter.trunks.demofestapp.base.util

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

/**
 * Описание функций
 */

/**
 * Скрываем клавиатуру
 */
fun Fragment.hideKeyboard() {
    val view = view!!.rootView.windowToken
    val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm?.hideSoftInputFromWindow(view, 0)
}

/**
 * Создаёт объект бандл и определяем в агументы фрагмента
 * @see Bundle
 */
fun Fragment.putArgs(argsBuilder: Bundle.() -> Unit): Fragment = this.apply { arguments = Bundle().apply(argsBuilder) }

