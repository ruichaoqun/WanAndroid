package com.ruichaoqun.wanandroid.ui.register

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class RegisterViewModel @ViewModelInject constructor(private val dataRepository: DataRepository):ViewModel() {
    var username:MutableLiveData<String> = MutableLiveData()
    var password:MutableLiveData<String> = MutableLiveData()
    var repassword:MutableLiveData<String> = MutableLiveData()

    private var _toast:MutableLiveData<String> = MutableLiveData()
    val toast:LiveData<String> = _toast

    private var _registerResponse:MutableLiveData<Any> = MutableLiveData()
    val registerResponse:LiveData<Any> = _registerResponse


    fun register(view:View){
        if(username.value.isNullOrEmpty()){
            _toast.value = "请输入用户名"
            return
        }
        if(password.value.isNullOrEmpty()){
            _toast.value = "请输入密码"
            return
        }
        if(repassword.value.isNullOrEmpty()){
            _toast.value = "请输入确认密码"
            return
        }
        viewModelScope.launch {
            try {
                val response = dataRepository.register(username.value!!, password.value!!,
                    repassword.value!!
                )
                _toast.value = "注册成功"
                _registerResponse.value = response.data
            }catch (e:Exception){
                e.printStackTrace()
                _toast.value = e.message
            }
        }
    }
}