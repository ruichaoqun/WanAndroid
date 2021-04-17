package com.ruichaoqun.wanandroid.common.fragment

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.ruichaoqun.wanandroid.common.viewmodel.BaseViewModel

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/15 16:50
 * @Description:    BaseMVVMFragment
 * @Version:        1.0
 */
abstract class BaseMVVMFragment<B:ViewDataBinding,VM: BaseViewModel>:BaseBindingFragment<B>() {
    protected lateinit var viewModel:VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(viewModelStore,defaultViewModelProviderFactory).get(viewModelClass())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun beforeInit() {
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
            finishPage()
        }
    }

    abstract fun viewModelClass(): Class<VM>

}