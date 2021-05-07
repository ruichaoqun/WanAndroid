package com.ruichaoqun.wanandroid.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.ruichaoqun.wanandroid.common.viewmodel.BaseViewModel
import com.ruichaoqun.wanandroid.common.paging.LoadMoreDataBean
import com.ruichaoqun.wanandroid.data.BannerBean
import com.ruichaoqun.wanandroid.data.DataRepository
import com.ruichaoqun.wanandroid.data.HomeListResponse
import com.ruichaoqun.wanandroid.utils.tryCatch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val dataRepository: DataRepository) : BaseViewModel() {
    private var _listData:MutableLiveData<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>> = MutableLiveData()
    val listData:LiveData<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>> = _listData

    private var _bannerData:MutableLiveData<MutableList<BannerBean>> = MutableLiveData()
    val bannerData:LiveData<MutableList<BannerBean>> = _bannerData

    init {
        viewModelScope.launch {
            dataRepository.getHomeList(null,null).collectLatest {
                _listData.value = it
            }
        }
        viewModelScope.launch {
            dataRepository.getHomeBanner().tryCatch({
                if(it.errorCode == 0){
                    _bannerData.value = it.data
                }else{
                    showToast(it.errorMsg)
                }
            },{
                showToast(it.message?:"")
            })
        }
    }
}