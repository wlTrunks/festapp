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
    constructor(month: Int, context: Context) : super(context) {
        this.month = month
        init()
    }

    constructor(month: Int, context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.month = month
        init()
    }

    constructor(month: Int, context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        this.month = month
        init()
    }

    lateinit var cal: Calendar
    var month: Int = 0
    lateinit var monthTitle: AppCompatTextView
    lateinit var list: RecyclerView
    fun init() {
        monthTitle
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
        println("SOUT dayOfWeek $dayOfWeek")
        for (i in dayOfWeek - 1 downTo 1) {
            println("SOUT dayOfWeek i $i")
            list.add(EmptyDays())
        }
        val maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        println("SOUT maxDay $maxDay")
        for (i in 0 until maxDay) {
            println("SOUT maxDay i $i")
            val day = i + 1
            println("SOUT day day $day")
            list.add(Days(day, "$day"))
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
