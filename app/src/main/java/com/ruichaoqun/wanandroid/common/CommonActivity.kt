package com.ruichaoqun.wanandroid.common

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.widget.LoadingDialog

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/6 16:38
 * @Description:    CommonActivity
 * @Version:        1.0
 */
abstract class CommonActivity<VM:CommonViewModel>:AppCompatActivity() {
    protected lateinit var viewModel:VM

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel = ViewModelProvider(viewModelStore,defaultViewModelProviderFactory).get(viewModelClass())
        initObserver()

    }

    private fun initObserver() {
        viewModel.loading.observe(this){
            loading(it)
        }
        viewModel.dismiss.observe(this){
            dismiss()
        }
    }

    abstract fun viewModelClass():Class<VM>

    private  val progressDialog: LoadingDialog by lazy {
        LoadingDialog(this).apply {
            setMessage(getString(R.string.common_loading))
            setCancelable(false)
        }
    }


    private fun loading(message: String){
        if (!progressDialog.isShowing) {
            progressDialog.apply {
                setMessage(message)
                show()
            }
        }
    }

    private fun loading(){
        if (!progressDialog.isShowing) {
            progressDialog.show()
        }
    }

    private fun dismiss(){
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }

    fun toast(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}