package com.ruichaoqun.wanandroid.ui.home

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
import com.ruichaoqun.luckymusicv2.view.paging.CommonLoadMoreAdapter
import com.ruichaoqun.luckymusicv2.view.paging.CommonRefreshAdapter
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.paging.withRefreshAndFooter
import com.ruichaoqun.wanandroid.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var binding:FragmentHomeBinding
    private val mAdapter:HomeAdapter = HomeAdapter()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.refreshLayout.setOnRefreshListener {
            mAdapter.refresh()
        }
        mAdapter.addLoadStateListener {
            binding.refreshLayout.isRefreshing = it.refresh is LoadState.Loading
        }
        binding.recyclerView.adapter = mAdapter.withRefreshAndFooter(
            refresh = CommonRefreshAdapter(null){
                mAdapter.retry()
            },
            footer = CommonLoadMoreAdapter{
                mAdapter.retry()
            }
        )
        viewModel.listData.observe(viewLifecycleOwner){
            lifecycleScope.launch{
                mAdapter.submitData(it)
            }
        }
    }
}