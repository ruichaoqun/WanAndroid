package com.ruichaoqun.wanandroid.data

import androidx.paging.PagingData
import com.ruichaoqun.wanandroid.common.paging.LoadMoreDataBean
import com.ruichaoqun.wanandroid.data.http.HttpRepository
import kotlinx.coroutines.flow.Flow

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/1 17:18
 * @Description:    DataRepository
 * @Version:        1.0
 */
class DataRepository(private val httpRepository: HttpRepository) :HttpRepository{
    override fun getHomeList(
        cid: String?,
        author: String?
    ): Flow<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>> {
        return httpRepository.getHomeList(cid,author)
    }

    override suspend fun getHomeBanner(): BaseResponse<MutableList<BannerBean>> {
        return httpRepository.getHomeBanner()
    }

    override suspend fun login(username: String, password: String): BaseResponse<Any> {
        return httpRepository.login(username,password)
    }

    override suspend fun register(
        username: String,
        password: String,
        repassword: String
    ): BaseResponse<Any> {
        return httpRepository.register(username,password,repassword)
    }

    override suspend fun getSystemTree(): BaseResponse<MutableList<SystemTreeBean>> {
        return httpRepository.getSystemTree()
    }

}