package com.barisic.news.util

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
object Common {
    private val sdfFrom = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    private val sdfTo = SimpleDateFormat("dd/MM/yyyy    HH:mm (z)")

    fun convertISOTimeToDate(isoTime: String): String? {
        val convertedDate: Date?
        var formattedDate: String? = null
        try {
            convertedDate = sdfFrom.parse(isoTime)
            formattedDate = sdfTo.format(convertedDate!!)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return formattedDate
    }
}