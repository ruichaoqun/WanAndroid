package com.ruichaoqun.wanandroid.common.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ruichaoqun.wanandroid.data.BaseResponse
import com.ruichaoqun.wanandroid.utils.tryCatch
import kotlinx.coroutines.launch

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/17 15:54
 * @Description:    BaseListViewModel
 * @Version:        1.0
 */
abstract class BaseListViewModel<T>: BaseViewModel() {
    private var _listBean:MutableLiveData<MutableList<T>> = MutableLiveData()
    var listBean:LiveData<MutableList<T>> = _listBean

    fun init(){
        viewModelScope.launch {
            showEmptyLoadingUI(true)
            fetchList().tryCatch({
                if(it.errorCode == 0){
                    _listBean.value = it.data?: mutableListOf()
                    showEmptyUI(it.data == null || it.data.size == 0)
                }else{
                    _listBean.value = mutableListOf()
                    showErrorUI(true)
                }
            },{
                showErrorUI(true)
            })
        }
    }

    abstract fun fetchList(): BaseResponse<MutableList<T>>
}