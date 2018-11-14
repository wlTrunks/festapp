package com.inter.trunks.demofestapp.calendar.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.calendar.model.CalendarItemType
import com.inter.trunks.demofestapp.calendar.model.Days
import com.inter.trunks.demofestapp.calendar.model.EmptyDays
import com.inter.trunks.demofestapp.calendar.model.WeekDays
import kotlinx.android.synthetic.main.calendar_item_day.view.*
import kotlinx.android.synthetic.main.calendar_item_weekday.view.*

class DaysAdapter(val list: MutableList<CalendarItemType>) : RecyclerView.Adapter<DaysAdapter.BaseVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH {
        if (viewType == 0) {
            return EmptyVH(LayoutInflater.from(parent.context).inflate(R.layout.calendar_item_empty, parent, false))
        }
        if (viewType == 1) return DayVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.calendar_item_day,
                parent,
                false
            )
        ) else return WeekDayVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.calendar_item_weekday,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseVH, position: Int) {
        when (list[position]) {
            is EmptyDays -> {
                if (list[position] is EmptyDays) {
                    val empty = list[position] as EmptyDays
                }
            }
            is Days -> {
                if (list[position] is Days) {
                    val days = list[position] as Days
                    val vh = holder as DayVH
                    vh.dayTitle.text = days.dayTitle
                    if (days.dayMonth == 24) {
                        vh.itemView.setOnClickListener({
                            Toast.makeText(holder.itemView.context, "new window", Toast.LENGTH_LONG).show()
                        })
                        vh.layoutEventLogo.addView(getEventLogo(holder.itemView.context))
                    }
                }
            }
            is WeekDays -> {
                if (list[position] is WeekDays) {
                    val weekDay = list[position] as WeekDays
                    val vh = holder as WeekDayVH
                    vh.weekDayTitle.text = weekDay.dayTitle
                }
            }
        }
        when (holder) {
            is EmptyVH -> {
            }
            is WeekDayVH -> {
            }
            is DayVH -> {
            }
        }
    }

    fun getEventLogo(context: Context): View {
        val eventLogo = AppCompatImageView(context)
        val param: ViewGroup.LayoutParams = ViewGroup.LayoutParams(
            context.resources.getDimension(R.dimen.calendar_day_event_logo).toInt(),
            context.resources.getDimension(R.dimen.calendar_day_event_logo).toInt()
        )
        eventLogo.layoutParams = param
        eventLogo.setBackgroundResource(R.drawable.comic_con)
        return eventLogo
    }

    override fun getItemViewType(position: Int): Int {
        val i = list[position].getType()
        return list[position].getType()
    }

    class DayVH(view: View) : BaseVH(view) {
        val dayTitle = view.day_title
        val layoutEventLogo = view.layout_event_logo
    }

    class WeekDayVH(view: View) : BaseVH(view) {
        val weekDayTitle = view.weekday_title
    }

    class EmptyVH(view: View) : BaseVH(view) {}
    open class BaseVH(view: View) : RecyclerView.ViewHolder(view)
}