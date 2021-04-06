package com.ruichaoqun.wanandroid.ui.login

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruichaoqun.wanandroid.data.DataRepository
import com.ruichaoqun.wanandroid.data.Status
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/6 10:40
 * @Description:    LoginViewModel
 * @Version:        1.0
 */
class LoginViewModel @ViewModelInject constructor(private val repository: DataRepository):ViewModel() {
    var account:MutableLiveData<String> = MutableLiveData()
    var password:MutableLiveData<String> = MutableLiveData()
    private var _toast:MutableLiveData<String> = MutableLiveData()
    val toast:LiveData<String> = _toast
    var registerEvent:MutableLiveData<Unit> = MutableLiveData()
    var loginSuccessEvent:MutableLiveData<Unit> = MutableLiveData()

    private var _loadingStatus:MutableLiveData<Status> = MutableLiveData()
    val loadingStatus:LiveData<Status> = _loadingStatus


    fun login(view:View){
        val accountString = account.value
        val passwordString = password.value
        if(accountString.isNullOrEmpty()){
            _toast.value = "请输入账号"
            return
        }
        if(passwordString.isNullOrEmpty()){
            _toast.value = "请输入密码"
            return
        }
        viewModelScope.launch {
            try {
                _loadingStatus.value = Status.LOADING
                val response = repository.login(accountString,passwordString)
                if(response.errorCode == 0){
                    loginSuccessEvent.value = Unit
                }else{
                    _toast.value = response.errorMsg
                }
            }catch(e:Exception) {
                _toast.value = e.message
            }finally {
                _loadingStatus.value = Status.SUCCESS
            }
        }
    }

    fun gotoRegister(view:View){
        registerEvent.value = Unit
    }
}