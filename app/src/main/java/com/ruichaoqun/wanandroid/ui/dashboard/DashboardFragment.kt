package com.ruichaoqun.wanandroid.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.fragment.BaseMVVMFragment
import com.ruichaoqun.wanandroid.databinding.FragmentDashboardBinding

class DashboardFragment : BaseMVVMFragment<FragmentDashboardBinding,DashboardViewModel>() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun getLayoutId(): Int = R.layout.fragment_dashboard


    override fun init(savedInstanceState: Bundle?) {
        binding.recyclerView.adapter =
    }

    override fun showEmptyLoadingUI(isShow: Boolean) {

    }

    override fun showErrorUI(isShow: Boolean) {

    }

    override fun viewModelClass(): Class<DashboardViewModel> = DashboardViewModel::class.java
}