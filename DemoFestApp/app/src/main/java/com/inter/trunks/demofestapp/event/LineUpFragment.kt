package com.inter.trunks.demofestapp.event

import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.ui.fragment.BaseFragment
import com.inter.trunks.demofestapp.base.util.putArgs
import com.inter.trunks.demofestapp.event.adapter.FavoriteLineupAdapter
import com.inter.trunks.demofestapp.event.adapter.LineupAdapter
import com.inter.trunks.demofestapp.event.di.EVENT_LINE_UP_VM
import com.inter.trunks.demofestapp.event.vm.LineUpVM
import kotlinx.android.synthetic.main.fragment_lineup.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LineUpFragment : BaseFragment() {

    companion object {
        private val TAG = this::class.java.simpleName
        val ONLY_FAVORITE = "only_favorite"
        fun instance(onlyFavorite: Boolean) = LineUpFragment().putArgs {
            putBoolean(ONLY_FAVORITE, onlyFavorite)
        }
    }

    var isOnlyFavorite: Boolean = false
    override fun getLayoutResources(): Int = R.layout.fragment_lineup

    val vm: LineUpVM by viewModel(name = EVENT_LINE_UP_VM)
    lateinit var adapter: LineupAdapter
    override fun initialize() {
        isOnlyFavorite = arguments?.getBoolean(ONLY_FAVORITE, false) as Boolean
        vm.load()
        setAdapter()
        subscribeEventBus()
    }

    protected fun subscribeEventBus() {
//        RXEventBus.process<String>({
//            if (it.equals(LineupAdapter.UPDATE_FAVORITE)) {
//                LogUtil.printLog(TAG, "process ")
//                refreshEventList()
//            }
//        }, compositeDisposable)
    }

    protected fun setAdapter() {
        adapter = if (isOnlyFavorite) FavoriteLineupAdapter {
            vm.eventItemLiveData.value = it
        } else LineupAdapter { vm.eventItemLiveData.value = it }
        adapter.setListItem(vm.getDumpList())
        recycler_list.adapter = adapter
        vm.setObserverEventItemList(this) {
            adapter.updateList(it)
        }
    }
}