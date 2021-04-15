package com.ruichaoqun.wanandroid.utils

import android.content.res.Resources
import android.util.TypedValue

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/15 18:25
 * @Description:    IntEx
 * @Version:        1.0
 */

val Int.dp
        get() = (Resources.getSystem().displayMetrics.density * this).toInt()

val Int.sp
        get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(),Resources.getSystem().displayMetrics)