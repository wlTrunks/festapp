package com.inter.trunks.demofestapp.calendar.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.calendar.model.CalendarItemType
import com.inter.trunks.demofestapp.calendar.model.Days
import com.inter.trunks.demofestapp.calendar.model.EmptyDays
import com.inter.trunks.demofestapp.calendar.model.WeekDays
import java.util.*

class CalendarView : LinearLayoutCompat {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    lateinit var cal: Calendar
    lateinit var monthTitle: AppCompatTextView
    lateinit var list: RecyclerView
    fun init() {
        inflate(context, R.layout.layout_month, this)
        monthTitle = rootView.findViewById(R.id.month_title)
        list = rootView.findViewById(R.id.list)
        list.layoutManager = GridLayoutManager(context, 7)

        cal = Calendar.getInstance()
        val month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
        monthTitle.text = month

        val daysList = mutableListOf<CalendarItemType>()
        addWeekDays(daysList)
        addDays(daysList)
        list.adapter = DaysAdapter(daysList)
    }

    fun addDays(list: MutableList<CalendarItemType>) {
        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, 1)
        val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1
        for (i in dayOfWeek - 1 downTo 1) {
            list.add(EmptyDays())
        }
        val maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        for (i in 0 until maxDay) {
            val day = i + 1
            list.add(Days(day, "$day", arrayListOf()))
        }
    }

    fun addWeekDays(list: MutableList<CalendarItemType>) {
        list.add(WeekDays(1, "MON"))
        list.add(WeekDays(2, "TUE"))
        list.add(WeekDays(3, "WED"))
        list.add(WeekDays(4, "THU"))
        list.add(WeekDays(5, "FRI"))
        list.add(WeekDays(6, "SAT"))
        list.add(WeekDays(7, "SUN"))
    }
}
