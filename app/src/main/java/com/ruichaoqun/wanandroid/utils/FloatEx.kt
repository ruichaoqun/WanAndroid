package com.ruichaoqun.wanandroid.utils

import android.content.res.Resources
import android.util.TypedValue

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/15 18:27
 * @Description:    FloatEx
 * @Version:        1.0
 */
val Float.dp
    get() = (Resources.getSystem().displayMetrics.density * this)

val Float.sp
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,this,Resources.getSystem().displayMetrics)