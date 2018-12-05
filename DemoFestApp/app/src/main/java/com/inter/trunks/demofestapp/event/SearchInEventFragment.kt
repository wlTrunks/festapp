package com.inter.trunks.demofestapp.event

import androidx.appcompat.widget.SearchView
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.ui.fragment.BaseFragment
import com.inter.trunks.demofestapp.base.util.LogUtil
import com.inter.trunks.demofestapp.event.adapter.LineupAdapter
import com.inter.trunks.demofestapp.event.di.EVENT_SEARCH_LINE_UP_VM
import com.inter.trunks.demofestapp.event.model.EventItem
import com.inter.trunks.demofestapp.event.vm.SearchInEventVM
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_lineup.*
import kotlinx.android.synthetic.main.fragment_search_in_event.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchInEventFragment : BaseFragment() {
    val vm: SearchInEventVM by viewModel(name = EVENT_SEARCH_LINE_UP_VM)
    val publishSubject: PublishSubject<String> = PublishSubject.create<String>()
    lateinit var adapter: LineupAdapter
    override fun getLayoutResources(): Int = R.layout.fragment_search_in_event

    override fun initialize() {
        vm.load()
        setAdapter()
        setTextWatcher()
        setSearchListener()
    }

    private fun setSearchListener() {
        vm.instantSearch(publishSubject, { adapter.updateList(it) })
    }

    private fun setTextWatcher() {
        search_event_edit_text.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                LogUtil.printLog("SearchInEventFragment", "query $query")
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                LogUtil.printLog("SearchInEventFragment", "newText $newText")
                publishSubject.onNext(newText)
                return false
            }
        })
    }

    protected fun setAdapter() {
        adapter = LineupAdapter { vm.eventItemLiveData.value = it }
        adapter.setListItem(vm.getDumpList())
        recycler_list.adapter = adapter
        vm.setObserverEventItemList(this) {
            adapter.updateList(it)
        }
    }
}