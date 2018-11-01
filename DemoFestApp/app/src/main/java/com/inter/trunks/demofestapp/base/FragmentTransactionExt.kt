package com.inter.trunks.demofestapp.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun FragmentManager.addFragment(fragment: Fragment, frameId: Int, addToBackStack: Boolean, tag: String) {
    val ft = beginTransaction()
    if (addToBackStack) {
        ft.addToBackStack(tag)
    }
    val fragmentOld = findFragmentById(frameId)
    if (fragmentOld != null) ft.hide(fragmentOld)
    ft.add(frameId, fragment, tag)
    ft.commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun Fragment.addFragment(fragment: Fragment, frameId: Int, addToBackStack: Boolean, tag: String) {
    activity?.supportFragmentManager?.inTransaction {
        if (addToBackStack) {
            addToBackStack(tag)
        }
        add(frameId, fragment, tag)
    }
}

fun Fragment.replaceFragment(fragment: Fragment, frameId: Int, addToBackStack: Boolean, tag: String) {
    activity?.supportFragmentManager?.inTransaction {
        if (addToBackStack) {
            addToBackStack(tag)
        }
        replace(frameId, fragment, tag)
    }
}

