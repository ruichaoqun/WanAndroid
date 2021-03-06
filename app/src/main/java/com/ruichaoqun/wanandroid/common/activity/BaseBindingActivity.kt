package com.ruichaoqun.wanandroid.common.activity

import android.content.ComponentName
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.ViewBehavior
import com.ruichaoqun.wanandroid.widget.LoadingDialog

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/14 14:54
 * @Description:    BaseBindingActivity
 * @Version:        1.0
 */
abstract class BaseBindingActivity<B:ViewDataBinding> :BaseActivity(), ViewBehavior{
    protected lateinit var binding:B
        private set

    private  val progressDialog: LoadingDialog by lazy {
        LoadingDialog(this).apply {
            setMessage(getString(R.string.common_loading))
            setCancelable(false)
        }
    }

    override fun initContentView() {
        initDataBinding()
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this,getLayoutId())
        binding.lifecycleOwner = this
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