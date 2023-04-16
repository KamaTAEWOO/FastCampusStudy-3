package com.fastcampus.chapter8.data.source.local

import androidx.room.TypeConverter
import com.fastcampus.chapter8.util.DateUtil
import java.sql.Timestamp
import java.util.*

class DateConverter {

    @TypeConverter
    fun toDate(timestamp: String?) : Date? {
        return timestamp?.let { DateUtil.dbDateFormat.parse(it) }
    }

    @TypeConverter
    fun toTimeStamp(date: Date?) : String? {
        return DateUtil.dbDateFormat.format(date)
    }
}