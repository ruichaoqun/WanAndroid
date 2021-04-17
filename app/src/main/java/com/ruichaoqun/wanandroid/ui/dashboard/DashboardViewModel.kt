package com.ruichaoqun.wanandroid.ui.dashboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ruichaoqun.wanandroid.common.viewmodel.BaseViewModel
import com.ruichaoqun.wanandroid.data.DataRepository
import com.ruichaoqun.wanandroid.data.SystemTreeBean
import com.ruichaoqun.wanandroid.utils.tryCatch
import kotlinx.coroutines.launch

class DashboardViewModel @ViewModelInject constructor(private val dataRepository: DataRepository) : BaseViewModel() {
    private var _treeBean = MutableLiveData<MutableList<SystemTreeBean>>()
    val treeBean:LiveData<MutableList<SystemTreeBean>> = _treeBean

    fun init(){
        showEmptyLoadingUI(true)
        viewModelScope.launch {
            dataRepository.getSystemTree().tryCatch({
                if(it.errorCode == 0){
                    _treeBean.value = it.data?: mutableListOf()
                }else{
                    showToast(it.errorMsg)
                    showErrorUI(true)
                }
            },{
                showToast(it.message?:"")
                showErrorUI(true)
            })
        }
    }
}