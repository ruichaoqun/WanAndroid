package com.ruichaoqun.wanandroid.ui.tree

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.ruichaoqun.wanandroid.common.paging.LoadMoreDataBean
import com.ruichaoqun.wanandroid.common.viewmodel.BaseViewModel
import com.ruichaoqun.wanandroid.data.DataRepository
import com.ruichaoqun.wanandroid.data.HomeListResponse
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TreeViewModel @ViewModelInject constructor(private val dataRepository: DataRepository): BaseViewModel() {
    private var _listData: MutableLiveData<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>> = MutableLiveData()
    val listData: LiveData<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>> = _listData

    fun refresh(cid:String?,author:String?){
        viewModelScope.launch {
            dataRepository.getHomeList(cid,author).collectLatest {
                _listData.value = it
            }
        }
    }
}