package com.inter.trunks.demofestapp.profile

import android.app.Dialog
import android.view.LayoutInflater
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment() {
    override fun initialize() {
        profile_my_events.setOnClickListener { it ->
            val dialog = Dialog(context)
            dialog.setContentView(LayoutInflater.from(context).inflate(R.layout.layout_my_events, null))
            dialog.show()
        }
    }
    override fun getLayoutResources(): Int = R.layout.fragment_profile
}