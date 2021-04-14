package com.ruichaoqun.wanandroid.common

import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/14 15:56
 * @Description:    BaseViewModel
 * @Version:        1.0
 */
open class BaseViewModel:ViewModel(),ViewBehavior {
    private var _loadingEvent = MutableLiveData<String?>()
    val loadingEvent:LiveData<String?> = _loadingEvent

    private var _dismissEvent = MutableLiveData<Boolean>()
    val dismissEvent:LiveData<Boolean> = _dismissEvent

    private var _showEmptyLoadingUIEvent = MutableLiveData<Boolean>()
    val showEmptyLoadingUIEvent:LiveData<Boolean> = _showEmptyLoadingUIEvent

    private var _showEmptyUIEvent = MutableLiveData<Boolean>()
    val showEmptyUIEvent:LiveData<Boolean> = _showEmptyUIEvent

    private var _showErrorUIEvent = MutableLiveData<Boolean>()
    val showErrorUIEvent:LiveData<Boolean> = _showErrorUIEvent

    private var _toastEvent = MutableLiveData<String>()
    val toastEvent:LiveData<String> = _toastEvent

    private var _navigateEvent = MutableLiveData<Class<*>>()
    val navigateEvent:LiveData<Class<*>> = _navigateEvent

    private var _backPressEvent = MutableLiveData<Any?>()
    val backPressEvenT:LiveData<Any?> = _backPressEvent

    private var _finishEvent = MutableLiveData<Any?>()
    val finishEvent:LiveData<Any?> = _finishEvent


    override fun showLoading(message: String?) {
        _loadingEvent.postValue(message)
    }

    override fun hideLoading() {
        _dismissEvent.postValue(true)
    }

    override fun showEmptyLoadingUI(isShow: Boolean) {
        _showEmptyLoadingUIEvent.postValue(isShow)
    }

    override fun showEmptyUI(isShow: Boolean) {
        _showEmptyUIEvent.postValue(isShow)
    }

    override fun showErrorUI(isShow: Boolean) {
        _showErrorUIEvent.postValue(isShow)
    }

    override fun showToast(message: String) {
        _toastEvent.postValue(message)
    }

    override fun navigate(cls: Class<*>) {
        _navigateEvent.postValue(cls)
    }

    override fun backPress() {
        _backPressEvent.postValue(null)
    }

    override fun finishPage() {
        _finishEvent.postValue(null)
    }


}