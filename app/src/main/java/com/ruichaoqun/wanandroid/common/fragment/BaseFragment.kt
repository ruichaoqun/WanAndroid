package com.ruichaoqun.wanandroid.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import java.util.concurrent.atomic.AtomicBoolean

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/14 18:21
 * @Description:    BaseFragment
 * @Version:        1.0
 */
abstract class BaseFragment:Fragment() {
    abstract fun getLayoutId(): Int
    private var hasInit:AtomicBoolean = AtomicBoolean(false)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        beforeInit()
    }

    override fun onResume() {
        super.onResume()
        if(hasInit.compareAndSet(false,true)){
            init()
        }
    }

    protected open fun beforeInit() {

    }

    abstract fun init()
}