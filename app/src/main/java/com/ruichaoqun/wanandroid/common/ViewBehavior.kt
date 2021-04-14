package com.ruichaoqun.wanandroid.common

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/14 15:07
 * @Description:    ViewBehavior
 * @Version:        1.0
 */
interface ViewBehavior {
    fun showLoading(message:String? = null)

    fun hideLoading()

    fun showEmptyLoadingUI(isShow: Boolean)

    fun showEmptyUI(isShow:Boolean)

    fun showErrorUI(isShow:Boolean)

    fun showToast(message:String)

    fun navigate(cls:Class<*>)

    fun backPress()

    fun finishPage()
}