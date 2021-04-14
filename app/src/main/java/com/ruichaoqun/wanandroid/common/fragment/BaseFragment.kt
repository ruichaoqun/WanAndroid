package com.ruichaoqun.wanandroid.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/14 18:21
 * @Description:    BaseFragment
 * @Version:        1.0
 */
abstract class BaseFragment:Fragment() {
    abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(getLayoutId(),null)
    }



}