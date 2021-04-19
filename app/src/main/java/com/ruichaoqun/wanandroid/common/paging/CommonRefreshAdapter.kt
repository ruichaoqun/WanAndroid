package com.ruichaoqun.luckymusicv2.view.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.ruichaoqun.wanandroid.common.paging.CommonViewBindingViewHolder
import com.ruichaoqun.wanandroid.databinding.CommonLoadingBinding
import com.ruichaoqun.wanandroid.databinding.PagingLoadingBinding

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/3/30 14:37
 * @Description:    CommonRefreshAdapter
 * @Version:        1.0
 */
class CommonRefreshAdapter(private val errorHint:String?,
                           private val retry:()->Unit?) : LoadStateAdapter<CommonViewBindingViewHolder<PagingLoadingBinding>>() {
    override fun onBindViewHolder(
        holder: CommonViewBindingViewHolder<PagingLoadingBinding>,
        loadState: LoadState
    ) {
        holder.binding.progressBar.isVisible = loadState is LoadState.Loading
        holder.binding.tvHint.isVisible = loadState is LoadState.Loading
        holder.binding.ivError.isVisible = loadState is LoadState.Error
        holder.binding.tvErrorHint.isVisible = loadState is LoadState.Error
        holder.binding.tvErrorHint.text = errorHint
        holder.binding.btnRetry.isVisible = loadState is LoadState.Error
        holder.binding.btnRetry.setOnClickListener {
            retry.invoke()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): CommonViewBindingViewHolder<PagingLoadingBinding> {
        val binding = PagingLoadingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommonViewBindingViewHolder(binding)
    }
}