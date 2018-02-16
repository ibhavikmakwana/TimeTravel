package com.timetravel

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import m.com.timetravel.R
import java.util.*


class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {

    }

    private lateinit var datePickerDialog: DatePickerDialog

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        if (view != null) {
            tv_main_day.text = day.toString()
            tv_main_month.text = month.toString()
            tv_main_year.text = year.toString()
            ll_main_date_view.visibility = View.VISIBLE
            btn_main_select_date.visibility = View.GONE
        }
    }

    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0
    private var mHour: Int = 0
    private var mMinute: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cal = Calendar.getInstance()
        mYear = cal.get(Calendar.YEAR)
        mMonth = cal.get(Calendar.MONTH)
        mDay = cal.get(Calendar.DAY_OF_MONTH)
        mHour = cal.get(Calendar.HOUR)
        mMinute = cal.get(Calendar.MINUTE)

        datePickerDialog = DatePickerDialog(this@MainActivity, this, mYear, mMonth, mDay)
        datePickerDialog.show()
    }

    fun openCalendar(view: View) {
        datePickerDialog.show()
    }
}