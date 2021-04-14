package com.ruichaoqun.wanandroid.common.activity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.ruichaoqun.wanandroid.common.BaseViewModel

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/14 15:54
 * @Description:    BaseMVVMActivity
 * @Version:        1.0
 */
abstract class BaseMVVMActivity<B:ViewDataBinding,VM: BaseViewModel>:BaseBindingActivity<B>() {
    protected lateinit var viewModel:VM
        private set

    protected abstract fun viewModelClass():Class<VM>

    override fun initContentView() {
        super.initContentView()
        initViewModel()
        initObserver()
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(viewModelStore,defaultViewModelProviderFactory).get(viewModelClass())
    }



    private fun initObserver() {
        viewModel.loadingEvent.observe(this){
            showLoading(it)
        }
        viewModel.dismissEvent.observe(this){
            hideLoading()
        }
        viewModel.showEmptyUIEvent.observe(this){
            showEmptyUI(it)
        }
        viewModel.showErrorUIEvent.observe(this){
            showErrorUI(it)
        }
        viewModel.toastEvent.observe(this){
            showToast(it)
        }
        viewModel.navigateEvent.observe(this){
            navigate(it)
        }
        viewModel.backPressEvenT.observe(this){
            backPress()
        }
        viewModel.finishEvent.observe(this){
            finish()
        }
    }


}