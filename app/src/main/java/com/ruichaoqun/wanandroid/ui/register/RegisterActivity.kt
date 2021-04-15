package com.ruichaoqun.wanandroid.ui.register

import android.os.Bundle
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.activity.BaseMVVMActivity
import com.ruichaoqun.wanandroid.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : BaseMVVMActivity<ActivityRegisterBinding, RegisterViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initialize(savedInstanceState: Bundle?) {
    }

    override fun showEmptyLoadingUI(isShow: Boolean) {
    }

    override fun showErrorUI(isShow: Boolean) {
    }

    override fun viewModelClass(): Class<RegisterViewModel> {
        return RegisterViewModel::class.java
    }
}