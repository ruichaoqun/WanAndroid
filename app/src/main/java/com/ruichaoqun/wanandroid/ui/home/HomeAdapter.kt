package com.ruichaoqun.wanandroid.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ruichaoqun.wanandroid.common.paging.BasePagingDataAdapter
import com.ruichaoqun.wanandroid.data.HomeListResponse
import com.ruichaoqun.wanandroid.databinding.ItemAdapterHomeBinding
import com.ruichaoqun.wanandroid.ui.detail.DetailActivity

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/3/26 17:00
 * @Description:    HomeAdapter
 * @Version:        1.0
 */
class HomeAdapter (): BasePagingDataAdapter<HomeListResponse.Data.Result, ItemAdapterHomeBinding>(
    { t1, t2 -> t1.value?.id == t2.value?.id },noDataHint = "真的一滴都没有了",{}
) {
    override fun createBinding(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): ItemAdapterHomeBinding {
        return ItemAdapterHomeBinding.inflate(layoutInflater, parent, false)
    }

    override fun convert(binding: ItemAdapterHomeBinding, item: HomeListResponse.Data.Result) {
        binding.item = item
        binding.root.setOnClickListener {
            binding.root.context.startActivity(Intent(binding.root.context, DetailActivity::class.java))
        }
    }

}