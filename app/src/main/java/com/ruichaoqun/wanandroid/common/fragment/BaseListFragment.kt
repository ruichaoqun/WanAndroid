package com.ruichaoqun.wanandroid.common.fragment

import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.ListStateHelper
import com.ruichaoqun.wanandroid.common.viewmodel.BaseListViewModel
import com.ruichaoqun.wanandroid.utils.setErrorLayout
import com.ruichaoqun.wanandroid.utils.setNoDataLayout
import javax.inject.Inject

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/19 15:10
 * @Description:    BaseListFragment
 * @Version:        1.0
 */
abstract class BaseListFragment<T,AD:BaseQuickAdapter<T,*>,B: ViewDataBinding,VM: BaseListViewModel<T>>:BaseMVVMFragment<B,VM>() {
    @Inject
    lateinit var mAdapter: AD
    private lateinit var listStateHelper: ListStateHelper

    override fun beforeInit() {
        super.beforeInit()
        viewModel.listBean.observe(this){
            mAdapter.setNewInstance(it)
        }
        listStateHelper = ListStateHelper(requireContext()).apply {
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
            context = requireContext())
    }

    override fun showErrorUI(isShow: Boolean) {
        mAdapter.setErrorLayout(
            imageResId = listStateHelper.errorDrawableRes,
            text = listStateHelper.errorHint,
            buttonText = listStateHelper.errorButtonText,
            callback = listStateHelper.errorRetry,
            context = requireContext()
        )
    }

    abstract fun initHelper(listStateHelper:ListStateHelper)
}