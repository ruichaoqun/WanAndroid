package com.ruichaoqun.wanandroid.common.activity

import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.ListStateHelper
import com.ruichaoqun.wanandroid.common.viewmodel.BaseListViewModel
import com.ruichaoqun.wanandroid.utils.setErrorLayout
import com.ruichaoqun.wanandroid.utils.setNoDataLayout

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/17 16:07
 * @Description:    BaseListActivity
 * @Version:        1.0
 */
abstract class BaseListActivity<T,B:ViewDataBinding,VM: BaseListViewModel<T>>:BaseMVVMActivity<B,VM>() {
    private lateinit var mAdapter:BaseQuickAdapter<T,*>
    private lateinit var listStateHelper:ListStateHelper

    override fun initContentView() {
        super.initContentView()
        viewModel.listBean.observe(this){
            mAdapter.setNewInstance(it)
        }
        listStateHelper = ListStateHelper(this).apply {
            errorRetry{
                viewModel.load()
            }
        }
    }

    override fun showEmptyLoadingUI(isShow: Boolean) {
        mAdapter.setEmptyView(R.layout.common_loading)
    }

    override fun showEmptyUI(isShow: Boolean) {
        mAdapter.setNoDataLayout(
            imageResId = listStateHelper.emptyDrawableRes,
            text = listStateHelper.emptyHint,
            buttonText = listStateHelper.emptyButtonText,
            callback = listStateHelper.emptyNavigate,
            context = this)
    }

    override fun showErrorUI(isShow: Boolean) {
        mAdapter.setErrorLayout(
            imageResId = listStateHelper.errorDrawableRes,
            text = listStateHelper.errorHint,
            buttonText = listStateHelper.errorButtonText,
            callback = listStateHelper.errorRetry,
            context = this
        )
    }

    abstract fun initHelper(listStateHelper:ListStateHelper)
}