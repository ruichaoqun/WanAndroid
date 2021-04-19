package com.ruichaoqun.wanandroid.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.ListStateHelper
import com.ruichaoqun.wanandroid.common.fragment.BaseListFragment
import com.ruichaoqun.wanandroid.common.fragment.BaseMVVMFragment
import com.ruichaoqun.wanandroid.data.SystemTreeBean
import com.ruichaoqun.wanandroid.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseListFragment<SystemTreeBean,SystemAdapter,FragmentDashboardBinding,DashboardViewModel>() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun getLayoutId(): Int = R.layout.fragment_dashboard

    override fun init(savedInstanceState: Bundle?) {
        binding.recyclerView.adapter = mAdapter
        viewModel.load()
    }

    override fun viewModelClass(): Class<DashboardViewModel> = DashboardViewModel::class.java

    override fun initHelper(listStateHelper: ListStateHelper) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.w("AAAAA","DashboardFragment  onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.w("AAAAA","DashboardFragment  onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.w("AAAAA","DashboardFragment  onViewCreated")
    }

    override fun onResume() {
        super.onResume()
        Log.w("AAAAA","DashboardFragment  onResume")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.w("AAAAA","DashboardFragment  onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("AAAAA","DashboardFragment  onDestroy")
    }
}