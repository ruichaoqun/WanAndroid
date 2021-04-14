package com.ruichaoqun.wanandroid.common.activity

import android.content.Intent
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.widget.LoadingDialog

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/14 17:07
 * @Description:    BaseAppBindingActivity
 * @Version:        1.0
 */
abstract class BaseAppBindingActivity<B:ViewDataBinding>:BaseBindingActivity<B>() {

    private  val progressDialog: LoadingDialog by lazy {
        LoadingDialog(this).apply {
            setMessage(getString(R.string.common_loading))
            setCancelable(false)
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