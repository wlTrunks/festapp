package com.inter.trunks.demofestapp.base.util

import android.content.Context
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager


fun Fragment.hideKeyboard() {
    val view = view!!.rootView.windowToken
    val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm?.hideSoftInputFromWindow(view, 0)
}