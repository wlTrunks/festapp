package com.inter.trunks.demofestapp.base.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.inter.trunks.demofestapp.R
import me.ilich.juggler.gui.JugglerFragment
import me.ilich.juggler.gui.JugglerToolbarFragment
import org.jetbrains.anko.find

/**
 * Стандартный тулбар для Juggler фрагментов
 */
open class CommonToolbarFragment : JugglerToolbarFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_common_toolbar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun getToolbarId(): Int {
        return R.id.toolbar
    }

    private fun setTitle(title: String) {
        context?.let {
            view?.let {
                it.find<Toolbar>(R.id.toolbar).title = title
            }
        }
    }

    companion object {

        private const val COMMON_TOOLBAR_RECEIVER_FILTER = "ru.app.volunteers.gui.base_common_toolbar_receiver_filter"
        private const val EXTRA_TITLE_RECEIVER = "extra_title_receiver"
        private const val EXTRA_TITLE_TEXT_RECEIVER = "extra_title_text_receiver"


        fun setTitle(context: Context?, stringId: Int) {
            context?.let {
                LocalBroadcastManager.getInstance(context).sendBroadcast(Intent(COMMON_TOOLBAR_RECEIVER_FILTER).apply { putExtra(EXTRA_TITLE_RECEIVER, stringId) })
            }
        }

        fun setTitle(context: Context?, title: String) {
            context?.let {
                LocalBroadcastManager.getInstance(context).sendBroadcast(Intent(COMMON_TOOLBAR_RECEIVER_FILTER).apply { putExtra(EXTRA_TITLE_TEXT_RECEIVER, title) })
            }
        }

        fun instance(): CommonToolbarFragment {
            val result = CommonToolbarFragment()
            val b = Bundle()
            JugglerToolbarFragment.addDisplayOptionsToBundle(b, ActionBar.DISPLAY_HOME_AS_UP or ActionBar.DISPLAY_SHOW_TITLE)
            result.arguments = b
            return result
        }

        fun createNavigation(): JugglerFragment {
            val f = CommonToolbarFragment()
            val b = JugglerToolbarFragment.addDisplayOptionsToBundle(null, ActionBar.DISPLAY_HOME_AS_UP or ActionBar.DISPLAY_SHOW_TITLE)
            f.arguments = b
            return f
        }

        fun createBack(): JugglerFragment {
            val f = CommonToolbarFragment()
            val b = JugglerToolbarFragment.addDisplayOptionsToBundle(null, ActionBar.DISPLAY_SHOW_TITLE or ActionBar.DISPLAY_HOME_AS_UP)
            f.arguments = b
            return f
        }
    }


}
