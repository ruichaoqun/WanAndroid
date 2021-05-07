package com.ruichaoqun.wanandroid.ui.tree

import android.graphics.Rect
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.ruichaoqun.luckymusicv2.view.paging.CommonLoadMoreAdapter
import com.ruichaoqun.luckymusicv2.view.paging.CommonRefreshAdapter
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.fragment.BaseMVVMFragment
import com.ruichaoqun.wanandroid.common.paging.withRefreshAndFooter
import com.ruichaoqun.wanandroid.databinding.TreeFragmentBinding
import com.ruichaoqun.wanandroid.ui.home.HomeAdapter
import com.ruichaoqun.wanandroid.utils.dp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TreeFragment : BaseMVVMFragment<TreeFragmentBinding,TreeViewModel>() {

    private val mAdapter: HomeAdapter = HomeAdapter()

    companion object {
        fun newInstance(id:String?,author:String?) = TreeFragment().apply {
            val bundle = Bundle()
            bundle.putString("cid",id)
            bundle.putString("author",author)
            arguments = bundle
        }
    }

    override fun viewModelClass(): Class<TreeViewModel> {
        return TreeViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.tree_fragment
    }

    override fun init() {
        binding.refreshLayout.setEnableLoadMore(false)
        binding.refreshLayout.setOnRefreshListener {
            mAdapter.refresh()
        }
        mAdapter.addLoadStateListener {
            if(it.refresh is LoadState.Loading){
                binding.refreshLayout.finishRefresh()
            }
        }
        binding.recyclerView.apply {
            adapter = mAdapter.withRefreshAndFooter(
                refresh = CommonRefreshAdapter(null){
                    mAdapter.retry()
                },
                footer = CommonLoadMoreAdapter{
                    mAdapter.retry()
                }
            )
            addItemDecoration(object : RecyclerView.ItemDecoration(){
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.set(16.dp,10.dp,16.dp,0)
                }
            })
        }
        viewModel.listData.observe(viewLifecycleOwner){
            lifecycleScope.launch{
                mAdapter.submitData(it)
            }
        }
        viewModel.refresh(arguments?.getString("cid"),arguments?.getString("author"))
    }

    override fun showEmptyLoadingUI(isShow: Boolean) {

    }

    override fun showErrorUI(isShow: Boolean) {

    }



}