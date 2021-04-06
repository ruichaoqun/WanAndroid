package com.ruichaoqun.wanandroid.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.data.Status
import com.ruichaoqun.wanandroid.databinding.ActivityLoginBinding
import com.ruichaoqun.wanandroid.ui.home.HomeViewModel
import com.ruichaoqun.wanandroid.ui.register.RegisterActivity
import com.ruichaoqun.wanandroid.widget.LoadingDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding:ActivityLoginBinding

    private  val progressDialog: LoadingDialog by lazy {
        LoadingDialog(this).apply {
            setMessage(getString(R.string.common_loading))
            setCancelable(false)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        binding.vm = viewModel
        viewModel.registerEvent.observe(this){
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        viewModel.loadingStatus.observe(this){
            when(it){
                Status.LOADING ->{
                    showLoading("")
                }
                Status.SUCCESS ->{
                    hideLoading()
                }
            }
        }
    }

    private fun showLoading(message: String){
        if (!progressDialog.isShowing) {
            progressDialog.apply {
                setMessage(message)
                show()
            }
        }
    }

    private fun hideLoading(){
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }
}