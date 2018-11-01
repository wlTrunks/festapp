package com.inter.trunks.demofestapp.base.ui.fragment

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

abstract class CommonMenuFragment : BaseFragment() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onItemMenuSelected(item.itemId)
        return when (item.itemId) {
            android.R.id.home -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(getMenuResources(), menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    abstract fun getMenuResources(): Int

    open fun onItemMenuSelected(itemId: Int) {}
}