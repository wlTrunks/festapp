package com.inter.trunks.demofestapp.event.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.event.model.EventItem
import kotlinx.android.synthetic.main.event_item_schedule.view.*

class LineupAdapter(val list: MutableList<EventItem>, val onCLick: (() -> Unit)) :
    RecyclerView.Adapter<LineupAdapter.LineUpVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineUpVH {
        val vh = LineUpVH(LayoutInflater.from(parent.context).inflate(R.layout.event_item_schedule, parent, false))
        vh
        return vh
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LineUpVH, position: Int) {
    }


    class LineUpVH(view: View) : RecyclerView.ViewHolder(view) {
        val checkBox = view.schedule_checkbox
    }
}