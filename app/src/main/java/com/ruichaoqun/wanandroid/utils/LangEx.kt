package com.ruichaoqun.wanandroid.utils

import com.ruichaoqun.wanandroid.BuildConfig

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/16 15:05
 * @Description:    LangEx
 * @Version:        1.0
 */

/**
 * 异常处理
 * @param printStack 异常时，是否调用printStackTrace方法打印日常
 */
inline fun <T> T.tryCatch(
    action: (T) -> Unit,
    catch:(e: Exception) -> Unit?) {
    try {
        action(this)
    } catch (e: Exception) {
        catch(e)
        if (BuildConfig.DEBUG) {
            e.printStackTrace()
        }
    }
}