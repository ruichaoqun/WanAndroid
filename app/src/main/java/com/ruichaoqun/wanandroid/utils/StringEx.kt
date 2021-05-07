package com.ruichaoqun.wanandroid.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/15 18:10
 * @Description:    StringEx
 * @Version:        1.0
 */
fun String?.getTimeCompareCurrentTime(): String {
    if (this == null) {
        return ""
    }
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
    val dateFormat1 = SimpleDateFormat("yyyy-MM-dd")
    try {
        val date = dateFormat.parse(this)
        val date1 = Date()
        val differenceValue = date1.time - date.time
        if (differenceValue < 3600000) {
            return if (differenceValue / 1000 / 60 == 0L) {
                "刚刚"
            } else {
                (differenceValue / 1000 / 60).toString() + "分钟前"
            }
        } else if (differenceValue > 3600000) {
            val currentDate = dateFormat1.format(date1)
            val targetDate = dateFormat1.format(date)
            return if (currentDate == targetDate) {
                //今日内：HH:MM
                val calendar = Calendar.getInstance()
                calendar.time = date
                val hour = calendar.get(Calendar.HOUR_OF_DAY)
                val min = calendar.get(Calendar.MINUTE)
                val hourStr = if (hour < 10) "0$hour" else hour
                val minStr = if (min < 10) "0$min" else min
                "${hourStr}:${minStr}"
            } else {
                if (currentDate.substring(0,currentDate.indexOf("-")) == targetDate.substring(0,targetDate.indexOf("-"))) {
                    //本年：显示MM-dd
                    targetDate.substring(targetDate.indexOf("-")+1)
                }else{
                    //4.其他：显示：yyyy-MM-dd
                    targetDate
                }
            }
//            return if (differenceValue < 86400000) {
//                (differenceValue / 1000 / 60 / 60).toString() + "小时前"
//            } else {
//                dateFormat1.format(date)
//            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return ""
}

fun Long?.getTimeCompareCurrentTime():String{
    if (this == null) {
        return ""
    }
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
    try {
        var date = dateFormat.format(Date(this))
        return date.getTimeCompareCurrentTime()
    }catch(e: Exception) {
        e.printStackTrace()
    }
    return ""
}