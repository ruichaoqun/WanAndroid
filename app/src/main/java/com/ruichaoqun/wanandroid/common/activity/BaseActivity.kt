package com.ruichaoqun.wanandroid.common.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/14 14:19
 * @Description:    BaseActivity
 * @Version:        1.0
 */
abstract class BaseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContentView()
        initialize(savedInstanceState)
    }

    abstract fun getLayoutId(): Int

    open fun initContentView() {
        setContentView(getLayoutId())
    }

    abstract fun initialize(savedInstanceState: Bundle?)

}