package com.ruichaoqun.wanandroid.widget

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.TextView
import androidx.core.widget.ContentLoadingProgressBar
import com.ruichaoqun.wanandroid.R

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/6 16:33
 * @Description:    LoadingDialog
 * @Version:        1.0
 */
class LoadingDialog(val windowContext: Context) : Dialog(windowContext, R.style.loading_dialog) {
    var mProgress: ContentLoadingProgressBar?=null
    var mMessageText: TextView?=null

    init {
        val layoutInflater = LayoutInflater.from(windowContext)
        val rootView = layoutInflater.inflate(R.layout.dialog_loading,null,false)
        mProgress = rootView.findViewById(R.id.progress_bar)
        mMessageText = rootView.findViewById(R.id.tv_message)
        setContentView(rootView)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun setMessage(message:String){
        mMessageText?.text = message
    }


}