package com.ruichaoqun.wanandroid.data.http

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ruichaoqun.wanandroid.common.paging.LoadMoreDataBean
import com.ruichaoqun.wanandroid.data.ApiService
import com.ruichaoqun.wanandroid.data.BaseResponse
import com.ruichaoqun.wanandroid.data.HomeListResponse
import com.ruichaoqun.wanandroid.data.pagingsource.HomePagingSource
import kotlinx.coroutines.flow.Flow

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/1 17:16
 * @Description:    DefaultHttpRepository
 * @Version:        1.0
 */
class DefaultHttpRepository(private val mApiService:ApiService):HttpRepository {
    override fun getHomeList(): Flow<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>> {
        return Pager(
            config = PagingConfig(pageSize = 20,enablePlaceholders = false),
            pagingSourceFactory = { HomePagingSource(mApiService) }
        ).flow
    }

    override suspend fun login(username:String,password:String): BaseResponse<Any> {
        return mApiService.login(username,password)
    }

    override suspend fun register(
        username: String,
        password: String,
        repassword: String
    ): BaseResponse<Any> {
        return mApiService.register(username,password,repassword)
    }


}