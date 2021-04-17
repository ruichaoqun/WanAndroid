package com.ruichaoqun.wanandroid.common.activity

import android.content.Intent
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.viewmodel.BaseViewModel
import com.ruichaoqun.wanandroid.widget.LoadingDialog

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/14 15:54
 * @Description:    BaseMVVMActivity
 * @Version:        1.0
 */
abstract class BaseMVVMActivity<B:ViewDataBinding,VM: BaseViewModel>:BaseBindingActivity<B>() {
    private  val progressDialog: LoadingDialog by lazy {
        LoadingDialog(this).apply {
            setMessage(getString(R.string.common_loading))
            setCancelable(false)
        }
    }

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



    override fun showLoading(message: String?) {
        if (!progressDialog.isShowing) {
            progressDialog.apply {
                if(!message.isNullOrEmpty()){
                    setMessage(message)
                }
                show()
            }
        }
    }

    override fun hideLoading() {
        progressDialog.dismiss()
    }

    override fun showEmptyUI(isShow: Boolean) {
    }

    override fun showToast(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    override fun navigate(cls: Class<*>) {
        startActivity(Intent(this,cls))
    }

    override fun backPress() {
        onBackPressed()
    }

    override fun finishPage() {
        finish()
    }


}