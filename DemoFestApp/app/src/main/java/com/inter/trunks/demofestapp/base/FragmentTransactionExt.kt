package com.inter.trunks.demofestapp.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

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

