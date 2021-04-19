package com.ruichaoqun.wanandroid.ui.dashboard

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.data.SystemTreeBean
import com.ruichaoqun.wanandroid.databinding.ItemAdapterSystemBinding
import javax.inject.Inject

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/16 18:18
 * @Description:    SystemAdapter
 * @Version:        1.0
 */
class SystemAdapter @Inject constructor():BaseQuickAdapter<SystemTreeBean,BaseDataBindingHolder<ItemAdapterSystemBinding>>(R.layout.item_adapter_system,null) {
    override fun convert(
        holder: BaseDataBindingHolder<ItemAdapterSystemBinding>,
        item: SystemTreeBean
    ) {
        holder.dataBinding?.bean = item
    }
}