package com.ruichaoqun.wanandroid.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.activity.BaseAppMVVMActivity
import com.ruichaoqun.wanandroid.data.Status
import com.ruichaoqun.wanandroid.databinding.ActivityLoginBinding
import com.ruichaoqun.wanandroid.ui.home.HomeViewModel
import com.ruichaoqun.wanandroid.ui.register.RegisterActivity
import com.ruichaoqun.wanandroid.widget.LoadingDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseAppMVVMActivity<ActivityLoginBinding,LoginViewModel>() {

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