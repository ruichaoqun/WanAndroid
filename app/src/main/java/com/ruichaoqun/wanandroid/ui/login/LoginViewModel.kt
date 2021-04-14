package com.ruichaoqun.wanandroid.ui.login

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruichaoqun.wanandroid.MainActivity
import com.ruichaoqun.wanandroid.common.BaseViewModel
import com.ruichaoqun.wanandroid.data.DataRepository
import com.ruichaoqun.wanandroid.data.Status
import com.ruichaoqun.wanandroid.ui.register.RegisterActivity
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/6 10:40
 * @Description:    LoginViewModel
 * @Version:        1.0
 */
class LoginViewModel @ViewModelInject constructor(private val repository: DataRepository):BaseViewModel() {
    var account:MutableLiveData<String> = MutableLiveData()
    var password:MutableLiveData<String> = MutableLiveData()

    fun login(view:View){
        val accountString = account.value
        val passwordString = password.value
        if(accountString.isNullOrEmpty()){
            showToast("请输入账号")
            return
        }
        if(passwordString.isNullOrEmpty()){
            showToast("请输入密码")
            return
        }
        viewModelScope.launch {
            try {
                showLoading()
                val response = repository.login(accountString,passwordString)
                if(response.errorCode == 0){
                    navigate(MainActivity::class.java)
                }else{
                    showToast(response.errorMsg)
                }
            }catch(e:Exception) {
                showToast(e.message?:"")
            }finally {
                hideLoading()
            }
        }
    }

    fun gotoRegister(view:View){
        navigate(RegisterActivity::class.java)
    }
}