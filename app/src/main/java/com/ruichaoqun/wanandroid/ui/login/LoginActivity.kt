package com.ruichaoqun.wanandroid.ui.login

import android.os.Bundle
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.activity.BaseMVVMActivity
import com.ruichaoqun.wanandroid.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseMVVMActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun viewModelClass(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun initialize(savedInstanceState: Bundle?) {
        binding.vm = viewModel
    }

    override fun showEmptyLoadingUI(isShow: Boolean) {
    }

    override fun showErrorUI(isShow: Boolean) {
    }

}