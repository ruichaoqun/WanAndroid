package com.ruichaoqun.wanandroid.common.activity

import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.viewmodel.BaseListViewModel

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/17 16:07
 * @Description:    BaseListActivity
 * @Version:        1.0
 */
abstract class BaseListActivity<T,B:ViewDataBinding,VM: BaseListViewModel<T>>:BaseMVVMActivity<B,VM>() {
    private lateinit var mAdapter:BaseQuickAdapter<T,*>

    override fun initContentView() {
        super.initContentView()
        viewModel.listBean.observe(this){
            mAdapter.setNewInstance(it)
        }
    }

    override fun showEmptyLoadingUI(isShow: Boolean) {
        mAdapter.setEmptyView(R.layout.paging_loading)
    }

    override fun showErrorUI(isShow: Boolean) {

    }
}