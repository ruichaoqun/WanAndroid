package com.ruichaoqun.wanandroid.data.pagingsource

import com.ruichaoqun.wanandroid.common.paging.SimplePagingSource
import com.ruichaoqun.wanandroid.data.ApiService
import com.ruichaoqun.wanandroid.data.BaseResponse
import com.ruichaoqun.wanandroid.data.HomeListResponse

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/3/26 14:57
 * @Description:    HomePagingSource
 * @Version:        1.0
 */
class HomePagingSource(private val apiService: ApiService):
    SimplePagingSource<HomeListResponse.Data, HomeListResponse.Data.Result>() {
    override suspend fun remoteLoad(position: Int): BaseResponse<HomeListResponse.Data> {
        return apiService.getHomeList(position)
    }

    override fun getList(response: BaseResponse<HomeListResponse.Data>): List<HomeListResponse.Data.Result>? {
        return response.data.datas
    }

    override fun hasNextPage(
        list: List<HomeListResponse.Data.Result>?,
        position: Int,
        response: BaseResponse<HomeListResponse.Data>
    ): Boolean {
        return response.data.curPage < response.data.pageCount
    }
}

