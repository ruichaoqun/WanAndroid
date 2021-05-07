package com.ruichaoqun.wanandroid.data.http

import androidx.paging.PagingData
import com.ruichaoqun.wanandroid.common.paging.LoadMoreDataBean
import com.ruichaoqun.wanandroid.data.BannerBean
import com.ruichaoqun.wanandroid.data.BaseResponse
import com.ruichaoqun.wanandroid.data.HomeListResponse
import com.ruichaoqun.wanandroid.data.SystemTreeBean
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
    fun getHomeList(cid:String?, author:String?): Flow<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>>

    suspend fun getHomeBanner():BaseResponse<MutableList<BannerBean>>

    suspend fun login(username:String,password:String):BaseResponse<Any>

    suspend fun register(username:String,password:String,repassword:String):BaseResponse<Any>

    suspend fun getSystemTree():BaseResponse<MutableList<SystemTreeBean>>
}