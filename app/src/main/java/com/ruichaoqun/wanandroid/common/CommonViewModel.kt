package com.ruichaoqun.wanandroid.common

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ruichaoqun.wanandroid.data.DataRepository

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/6 17:09
 * @Description:    CommonViewModel
 * @Version:        1.0
 */
class CommonViewModel:ViewModel() {
    private var _loading:MutableLiveData<String> = MutableLiveData()
    val loading:LiveData<String> = _loading

    private var _dismiss:MutableLiveData<Unit> = MutableLiveData()
    val dismiss:LiveData<Unit> = _dismiss

    fun showLoading(message:String?="加载中"){
        _loading.value = message
    }

    fun dismiss(){
        _dismiss.value = Unit
    }
}