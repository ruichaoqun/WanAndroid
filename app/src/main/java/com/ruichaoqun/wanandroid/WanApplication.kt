package com.ruichaoqun.wanandroid

import android.app.Application
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import dagger.hilt.android.HiltAndroidApp

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/1 16:15
 * @Description:    WanApplication
 * @Version:        1.0
 */
@HiltAndroidApp
class WanApplication:Application() {
    init {
//        refreshLayout全局指定Header和Footer
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(android.R.color.white) //全局设置主题颜色
            ClassicsHeader(context) //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        }
//        设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout -> //指定为经典Footer，默认是 BallPulseFooter
            ClassicsFooter(context).setDrawableSize(20f)
        }
    }

    override fun onCreate() {
        super.onCreate()

    }
}