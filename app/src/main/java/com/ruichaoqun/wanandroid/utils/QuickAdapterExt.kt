package com.ruichaoqun.wanandroid.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.ClickCallback

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/9/24 20:07
 * @Description:    QuickAdapterExt
 * @Version:        1.0
 */

/**
 * 展示空数据empty View
 * @receiver BaseQuickAdapter<*, *>
 * @param imageResId Int?
 * @param text String?
 * @param buttonText String?
 * @param callback Function0<Unit>?
 */
fun BaseQuickAdapter<*, *>.setNoDataLayout(
    imageResId: Int? = R.drawable.ic_empty,
    text: String? = "暂无数据",
    buttonText: String? = "",
    showInCenter:Boolean? = true,
    context: Context,
    callback: ClickCallback ?= null
) {
    var view: View = LayoutInflater.from(context)
        .inflate(R.layout.common_layout_no_data, null)
    if (imageResId != null) {
        view.findViewById<ImageView>(R.id.iv_no_data).setImageResource(imageResId)
    }
    showInCenter?.let {
        if(!it){
            val v = view.findViewById<View>(R.id.layout_center)
            val pa = v.layoutParams as RelativeLayout.LayoutParams
            pa.removeRule(RelativeLayout.CENTER_IN_PARENT)
            pa.addRule(RelativeLayout.CENTER_HORIZONTAL)
            pa.topMargin = 60.dp
            v.layoutParams = pa
        }
    }
    view.findViewById<TextView>(R.id.tv_content).text = text
    if (callback != null) {
        view.findViewById<TextView>(R.id.tv_navigate).visibility = View.VISIBLE
        view.findViewById<TextView>(R.id.tv_navigate).text = buttonText
        view.findViewById<TextView>(R.id.tv_navigate).setOnClickListener { callback.invoke() }
    } else {
        view.findViewById<TextView>(R.id.tv_navigate).visibility = View.GONE
    }
    this.setEmptyView(view)
}

/**
 * 展示网络异常empty View
 * @receiver BaseQuickAdapter<*, *>
 * @param imageResId Int?
 * @param text String?
 * @param buttonText String?
 * @param callback Function0<Unit>?
 */
fun BaseQuickAdapter<*, *>.setErrorLayout(
    imageResId: Int? = R.drawable.ic_error,
    text: String? = "网络异常",
    buttonText: String? = "点击重试",
    showInCenter:Boolean? = true,
    context: Context,
    callback: ClickCallback ?= null
) {
    var view: View = LayoutInflater.from(context)
        .inflate(R.layout.common_layout_no_data, null)
    if (imageResId != null) {
        view.findViewById<ImageView>(R.id.iv_no_data).setImageResource(imageResId)
    }
    showInCenter?.let {
        if(!it){
            val v = view.findViewById<View>(R.id.layout_center)
            val pa = v.layoutParams as RelativeLayout.LayoutParams
            pa.removeRule(RelativeLayout.CENTER_IN_PARENT)
            pa.addRule(RelativeLayout.CENTER_HORIZONTAL)
            pa.topMargin = 60.dp
            v.layoutParams = pa
        }
    }
    view.findViewById<TextView>(R.id.tv_content).text = text
    if (callback != null) {
        view.findViewById<TextView>(R.id.tv_navigate).visibility = View.VISIBLE
        view.findViewById<TextView>(R.id.tv_navigate).text = buttonText
        view.findViewById<TextView>(R.id.tv_navigate).setOnClickListener { callback.invoke() }
    } else {
        view.findViewById<TextView>(R.id.tv_navigate).visibility = View.GONE
    }
    this.setEmptyView(view)
}

/**
 *
 * @receiver BaseQuickAdapter<*, *>
 * @param loadMore Boolean?  是否需要加载更多
 */
//fun RecyclerView.addNoMoreDataView(loadMore: Boolean? = true) {
//    this.adapter?.let {
//        tryCatch {
//            var mAdapter = it as BaseQuickAdapter<*, *>
//            //加载更多，移除底部提示
//            if (loadMore == true) {
//                mAdapter.removeAllFooterView()
//                return
//            }
//            //不加载更多，如果item大于1个，展示底部提示
//            if (mAdapter.itemCount > 1) {
//                var view: View = LayoutInflater.from(BaseApplication.instance.applicationContext)
//                    .inflate(R.layout.common_layout_no_more_data, null)
//                mAdapter.setFooterView(view)
//            }
//        }
//    }
//}
//
//fun BaseQuickAdapter<*, *>.addNoMoreDataView(loadMore: Boolean? = true,minItemCount:Int? = 5) {
//    tryCatch {
//        //加载更多，移除底部提示
//        if (loadMore == true) {
//            this.removeAllFooterView()
//            return
//        }
//        //不加载更多，如果item大于5个，展示底部提示
//        if (this.itemCount > minItemCount?:0) {
//            var view: View = LayoutInflater.from(BaseApplication.instance.applicationContext)
//                .inflate(R.layout.common_layout_no_more_data, null)
//            this.setFooterView(view)
//        }
//    }
//}