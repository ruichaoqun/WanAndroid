package com.ruichaoqun.wanandroid.data.http

import androidx.paging.PagingData
import com.ruichaoqun.wanandroid.common.paging.LoadMoreDataBean
import com.ruichaoqun.wanandroid.data.BaseResponse
import com.ruichaoqun.wanandroid.data.HomeListResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Path

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/1 17:15
 * @Description:    HttpRepository
 * @Version:        1.0
 */
interface HttpRepository {
    fun getHomeList(): Flow<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>>
}