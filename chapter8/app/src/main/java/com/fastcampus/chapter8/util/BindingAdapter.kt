package com.fastcampus.chapter8.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.*

@BindingAdapter("date")
fun TextView.setDate(date : Date?) {
    text = DateUtil.convertPrintDateString(date)
}