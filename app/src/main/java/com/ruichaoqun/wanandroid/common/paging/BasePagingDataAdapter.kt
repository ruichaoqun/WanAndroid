package com.ruichaoqun.wanandroid.common.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ruichaoqun.wanandroid.R
import java.lang.RuntimeException

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/3/26 17:05
 * @Description:    BasePagingDataAdapter
 * @Version:        1.0
 */
typealias NavigationCallback = ()->Unit
abstract class BasePagingDataAdapter<T:Any,VB: ViewBinding>(areItemsTheSame:(oldItem: LoadMoreDataBean<T>,
                                                                             newItem: LoadMoreDataBean<T>)->Boolean
,private val noDataHint:String ?= "暂无数据",
private val navigation:NavigationCallback ?= null): PagingDataAdapter<LoadMoreDataBean<T>, BasePagingDataAdapter.BaseViewHolder<VB>>(
    object : DiffUtil.ItemCallback<LoadMoreDataBean<T>>(){
        override fun areItemsTheSame(
            oldItem: LoadMoreDataBean<T>,
            newItem: LoadMoreDataBean<T>
        ): Boolean {
            return areItemsTheSame(oldItem,newItem)
        }

        override fun areContentsTheSame(
            oldItem: LoadMoreDataBean<T>,
            newItem: LoadMoreDataBean<T>
        ): Boolean {
            return oldItem == newItem
        }
    }
) {

    class BaseViewHolder<VB: ViewBinding>(val binding:VB?,val view:View ?= null): RecyclerView.ViewHolder(
        binding?.root ?: view?: throw RuntimeException("必须传binding或者view一种")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        when(viewType){
            0->{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = createBinding(layoutInflater,parent)
                return BaseViewHolder(binding)
            }
            1->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_no_more_data,parent,false)
                return BaseViewHolder(null,view)
            }
            2->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_no_data,parent,false)
                return BaseViewHolder(null,view)
            }
            else->{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = createBinding(layoutInflater,parent)
                return BaseViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        when(getItemViewType(position)){
            0 ->{
                val item = getItem(position)
                item?.value?.let {
                    convert(holder.binding!!,it)
                }
            }
            1 ->{

            }
            2 ->{
                val tv:TextView? = holder.view?.findViewById(R.id.tv_hint)
                val rb:TextView? = holder.view?.findViewById(R.id.tv_navigation)
                tv?.apply {
                    text = noDataHint
                }
                rb?.apply {
                    isVisible = navigation != null
                    setOnClickListener {
                        navigation?.invoke()
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item?.type?:0
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        val manager = recyclerView.layoutManager
        if (manager is GridLayoutManager) {
            val defSpanSizeLookup = manager.spanSizeLookup
            manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    val type = getItemViewType(position)
                    if (type == 0) {
                        return 1
                    }
                    return manager.spanCount
                }
            }
        }
    }

    abstract fun createBinding(layoutInflater: LayoutInflater, parent: ViewGroup):VB

    abstract fun convert(binding: VB,item:T)
}

