package com.inter.trunks.demofestapp.registration

import android.widget.Toast
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.ui.fragment.CommonMenuFragment

class RegistrationFragment : CommonMenuFragment() {

    override fun getLayoutResources(): Int = R.layout.fragment_registration
    override fun getMenuResources(): Int = R.menu.confirm_menu
    override fun initialize() {
    }

    override fun onItemMenuSelected(itemId: Int) {
       Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show()
    }
}