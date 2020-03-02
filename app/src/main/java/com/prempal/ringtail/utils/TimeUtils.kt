package com.prempal.ringtail.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by prempal on 3/2/20.
 */
@SuppressLint("SimpleDateFormat")
val outputFormatter = SimpleDateFormat("dd/MM/yy HH:mm")

@SuppressLint("SimpleDateFormat")
val inputFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

fun convertTime(
    time: String,
    inputFormat: SimpleDateFormat = inputFormatter,
    outputFormat: SimpleDateFormat = outputFormatter): String {
    try {
        val date = inputFormat.parse(time)
        return date?.let { outputFormat.format(it) } ?: time
    } catch (e: ParseException) {

    }
    return time
}
