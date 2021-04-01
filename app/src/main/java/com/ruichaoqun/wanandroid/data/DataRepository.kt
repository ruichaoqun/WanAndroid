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
    override fun getHomeList(): Flow<PagingData<LoadMoreDataBean<HomeListResponse.Data.Result>>> {
        return httpRepository.getHomeList()
    }

}