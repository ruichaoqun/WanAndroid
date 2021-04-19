package com.ruichaoqun.wanandroid.common

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ruichaoqun.wanandroid.R

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/19 14:08
 * @Description:    ListStateHelper
 * @Version:        1.0
 */

typealias ClickCallback = ()->Unit
class ListStateHelper(val context: Context) {
     var emptyDrawableRes:Int ?= null
     var emptyHint:String ?= null
     var emptyButtonText:String ?= null
     var emptyNavigate:ClickCallback ?= null

     var errorDrawableRes:Int ?= null
     var errorHint:String ?= null
     var errorButtonText:String ?= null
     var errorRetry:ClickCallback ?= null

    init {
        emptyDrawableRes = R.drawable.ic_empty
        emptyHint = context.resources.getString(R.string.common_empty)
        emptyButtonText = context.resources.getString(R.string.common_empty)
        errorDrawableRes = R.drawable.ic_error
        errorHint = context.resources.getString(R.string.common_error)
        errorButtonText = context.resources.getString(R.string.common_retry)
        emptyNavigate = {}
        errorRetry  = {}
    }

    fun emptyDrawableRes(@DrawableRes res:Int?) = apply {
        emptyDrawableRes = res?:R.drawable.ic_empty
    }

    fun emptyHint(@StringRes res: Int? = null, text: String? = null) = apply {
        emptyHint = text ?: context.resources.getString(res?: R.string.common_empty)
    }

    fun emptyButtonText(@StringRes res: Int? = null, text: String? = null) = apply {
        emptyButtonText = text ?: context.resources.getString(res?: R.string.common_empty)
    }

    fun emptyNavigate(callback:ClickCallback) = apply {
        emptyNavigate = callback?:{}
    }

    fun errorDrawableRes(res:Int?) = apply {
        errorDrawableRes = res?:R.drawable.ic_error
    }

    fun errorHint(@StringRes res: Int? = null, text: String? = null) = apply {
        errorHint = text ?: context.resources.getString(res?: R.string.common_error)
    }

    fun errorButtonText(@StringRes res: Int? = null, text: String? = null) = apply {
        errorButtonText = text ?: context.resources.getString(res?: R.string.common_retry)
    }

    fun errorRetry(callback:ClickCallback) = apply {
        errorRetry = callback?:{}
    }
}