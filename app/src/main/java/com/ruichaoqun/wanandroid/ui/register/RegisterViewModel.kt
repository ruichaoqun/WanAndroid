package com.ruichaoqun.wanandroid.ui.register

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ruichaoqun.wanandroid.MainActivity
import com.ruichaoqun.wanandroid.common.viewmodel.BaseViewModel
import com.ruichaoqun.wanandroid.data.DataRepository
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/6 13:56
 * @Description:    RegisterViewModel
 * @Version:        1.0
 */
class RegisterViewModel @ViewModelInject constructor(private val dataRepository: DataRepository):
    BaseViewModel() {
    var username:MutableLiveData<String> = MutableLiveData()
    var password:MutableLiveData<String> = MutableLiveData()
    var repassword:MutableLiveData<String> = MutableLiveData()


    fun register(view:View){
        if(username.value.isNullOrEmpty()){
            showToast("请输入用户名")
            return
        }
        if(password.value.isNullOrEmpty()){
            showToast("请输入密码")
            return
        }
        if(repassword.value.isNullOrEmpty()){
            showToast("请输入确认密码")
            return
        }
        viewModelScope.launch {
            try {
                val response = dataRepository.register(username.value!!, password.value!!,
                    repassword.value!!
                )
                showToast("注册成功")
                navigate(MainActivity::class.java)
            }catch (e:Exception){
                e.printStackTrace()
                showToast(e.message?:"")
            }
        }
    }
}