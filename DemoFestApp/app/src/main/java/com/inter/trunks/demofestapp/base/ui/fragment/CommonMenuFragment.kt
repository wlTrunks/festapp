package com.inter.trunks.demofestapp.base.ui.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.inter.trunks.demofestapp.base.util.LogUtil
import com.inter.trunks.demofestapp.base.util.hideKeyboard

abstract class CommonMenuFragment : BaseFragment() {


    abstract fun getMenuResources(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        menu?.clear()
        inflater?.inflate(getMenuResources(), menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        hideKeyboard()
        LogUtil.printLog("CommonMenuFragment", "onOptionsItemSelected ${item.itemId}")
        onMenuItemSelected(item.itemId)
        return true
    }

    open fun onMenuItemSelected(itemId: Int) {
    }
}