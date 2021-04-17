package com.ruichaoqun.wanandroid.ui.home

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.data.BannerBean
import com.ruichaoqun.wanandroid.databinding.ItemAdapterHomeBinding
import com.ruichaoqun.wanandroid.databinding.LayoutHomeBannerBinding
import com.youth.banner.adapter.BannerAdapter
import java.text.SimpleDateFormat

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/16 16:03
 * @Description:    HomeBannerAdapter
 * @Version:        1.0
 */
class HomeBannerAdapter(data:MutableList<BannerBean>): BannerAdapter<BannerBean, HomeBannerAdapter.ViewHolder>(data) {
    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val binding = LayoutHomeBannerBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return ViewHolder(binding.root,binding)
    }

    class ViewHolder(itemView: View,val binding:LayoutHomeBannerBinding) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onBindView(
        holder: ViewHolder,
        data: BannerBean,
        position: Int,
        size: Int
    ) {
        holder.binding.bean = data
    }
}