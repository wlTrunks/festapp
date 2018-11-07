package com.inter.trunks.demofestapp.registration

import android.content.Intent
import android.widget.Toast
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.app.MainActivity
import com.inter.trunks.demofestapp.base.ui.fragment.CommonMenuFragment
import com.inter.trunks.demofestapp.base.util.LogUtil
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.android.synthetic.main.layout_login_password.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : CommonMenuFragment() {


    val vm: RegistrationVM by viewModel()

    override fun getLayoutResources(): Int = R.layout.fragment_registration
    override fun getMenuResources(): Int = R.menu.confirm_menu
    override fun initialize() {
    }

    override fun onMenuItemSelected(itemId: Int) {
        LogUtil.printLog("RegistrationFragment", "onItemMenuSelected")
        vm.singUp(
            login = login.text.toString().trim(),
            pass = password.text.toString().trim(),
            repeatPass = repeat_password.text.toString().trim(),
            onResult = {
                activity?.finishAffinity()
                startActivity(Intent(context, MainActivity::class.java))
            },
            onFail = {
                Toast.makeText(context, "Password not match", Toast.LENGTH_SHORT).show()
            }
        )
    }
}