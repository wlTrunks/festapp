package com.inter.trunks.demofestapp.event.adapter

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.util.LogUtil
import com.inter.trunks.demofestapp.event.model.EventItem
import kotlinx.android.synthetic.main.event_item_schedule.view.*

open class LineupAdapter(val OnCheckedChanged: (MutableList<EventItem>) -> Unit) :
    RecyclerView.Adapter<LineupAdapter.LineUpVH>() {
    companion object {
        val UPDATE_FAVORITE = "update_favorite"
    }

    protected val list: SparseArray<EventItem> = SparseArray()

    open fun setListItem(list: MutableList<EventItem>) {
        for (eventItem in list) {
            this.list.put(eventItem.order, eventItem)
        }
        notifyDataSetChanged()
    }

    open fun updateList(newList: MutableList<EventItem>) {
        list.clear()
        for (eventItem in newList) {
            this.list.put(eventItem.order, eventItem)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineUpVH {
        val vh = LineUpVH(LayoutInflater.from(parent.context).inflate(R.layout.event_item_schedule, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        return list.size()
    }

    override fun onBindViewHolder(holder: LineUpVH, position: Int) {
        holder.scheduleTitle.text = list.valueAt(position).title
        holder.scheduleTime.text = list.valueAt(position).beginTime
        holder.checkBox.isChecked = list.valueAt(position).isChecked
        holder.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (buttonView.isPressed) {
                onCheckEventItem(list.valueAt(position).uuid, position, isChecked)
            }
        }
    }

    open fun onCheckEventItem(id: Int, position: Int, isChecked: Boolean) {
        list.valueAt(position).isChecked = isChecked
        OnCheckedChanged.invoke(getNewList(list))
    }


    open fun getNewList(sparseArray: SparseArray<EventItem>): MutableList<EventItem> {
        val newList = mutableListOf<EventItem>()
        for (i in 0 until sparseArray.size()) {
            newList.add(sparseArray.valueAt(i))
        }
        return newList
    }

    class LineUpVH(view: View) : RecyclerView.ViewHolder(view) {
        val checkBox = view.schedule_checkbox
        val scheduleTitle = view.schedule_title
        val scheduleTime = view.schedule_begin_time
    }
}