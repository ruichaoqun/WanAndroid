package com.ruichaoqun.wanandroid.ui.home

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.ruichaoqun.luckymusicv2.view.paging.CommonLoadMoreAdapter
import com.ruichaoqun.luckymusicv2.view.paging.CommonRefreshAdapter
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.fragment.BaseMVVMFragment
import com.ruichaoqun.wanandroid.common.paging.withRefreshAndFooter
import com.ruichaoqun.wanandroid.databinding.FragmentHomeBinding
import com.ruichaoqun.wanandroid.utils.dp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseMVVMFragment<FragmentHomeBinding,HomeViewModel>() {

    private val mAdapter:HomeAdapter = HomeAdapter()

    override fun viewModelClass(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun init(savedInstanceState: Bundle?) {
        binding.refreshLayout.setOnRefreshListener {
            mAdapter.refresh()
        }
        mAdapter.addLoadStateListener {
            binding.refreshLayout.isRefreshing = it.refresh is LoadState.Loading
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
            addItemDecoration(object :RecyclerView.ItemDecoration(){
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
    }

    override fun showEmptyLoadingUI(isShow: Boolean) {
    }

    override fun showErrorUI(isShow: Boolean) {
    }


}