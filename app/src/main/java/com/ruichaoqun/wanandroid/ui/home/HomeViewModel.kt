package com.ruichaoqun.wanandroid.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.ruichaoqun.wanandroid.common.paging.LoadMoreDataBean
import com.ruichaoqun.wanandroid.data.DataRepository
import com.ruichaoqun.wanandroid.data.HomeListResponse
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val dataRepository: DataRepository) : ViewModel() {
    private var _listData:MutableLiveData<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>> = MutableLiveData()

    val listData:LiveData<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>> = _listData
    init {
        viewModelScope.launch {
            dataRepository.getHomeList().collectLatest {
                _listData.value = it
            }
        }
    }
}