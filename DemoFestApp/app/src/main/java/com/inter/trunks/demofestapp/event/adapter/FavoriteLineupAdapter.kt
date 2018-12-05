package com.inter.trunks.demofestapp.event.adapter

import android.util.SparseArray
import com.inter.trunks.demofestapp.event.model.EventItem

class FavoriteLineupAdapter(OnCheckedChanged: (MutableList<EventItem>) -> Unit) : LineupAdapter(OnCheckedChanged) {
    var unsortedList: SparseArray<EventItem> = SparseArray()

    override fun setListItem(list: MutableList<EventItem>) {
        for (eventItem in list) {
            unsortedList.put(eventItem.order, eventItem)
        }
        for (eventItem in list.filter { eventItem -> eventItem.isChecked }) {
            this.list.put(eventItem.order, eventItem)
        }
        notifyDataSetChanged()
    }

    override fun updateList(newList: MutableList<EventItem>) {
        list.clear()
        for (eventItem in newList.filter { eventItem -> eventItem.isChecked }) {
            this.list.put(eventItem.order, eventItem)
        }
        notifyDataSetChanged()
    }

    override fun onCheckEventItem(id: Int, position: Int, isChecked: Boolean) {
        for (i in 0 until unsortedList.size()) {
            if (unsortedList.valueAt(i).uuid == id) {
                unsortedList.valueAt(i).isChecked = isChecked
            }
        }
        list.removeAt(position)
        notifyItemRemoved(position)
        OnCheckedChanged.invoke(getNewList(unsortedList))
    }
}