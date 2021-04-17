package com.ruichaoqun.wanandroid.binding

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/16 16:22
 * @Description:    ViewBinding
 * @Version:        1.0
 */
object ViewBinding {

    @JvmStatic
    @BindingAdapter("url")
    fun bindImageUr(view:ImageView,url:String){
        Log.w("AAAAA",url)
        Glide.with(view)
            .load(url)
            .into(view)
    }
}