package com.ruichaoqun.wanandroid.common.activity

import android.content.ComponentName
import android.content.Intent
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.ruichaoqun.wanandroid.common.ViewBehavior

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

    override fun initContentView() {
        initDataBinding()
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this,getLayoutId())
        binding.lifecycleOwner = this
    }
}