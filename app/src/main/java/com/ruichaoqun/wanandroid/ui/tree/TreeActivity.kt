package com.ruichaoqun.wanandroid.ui.tree

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.CommonFragmentManager
import com.ruichaoqun.wanandroid.common.activity.BaseBindingActivity
import com.ruichaoqun.wanandroid.data.SystemTreeBean
import com.ruichaoqun.wanandroid.databinding.ActivityTreeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TreeActivity : BaseBindingActivity<ActivityTreeBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_tree
    }

    override fun initialize(savedInstanceState: Bundle?) {
        intent?.apply {
            val listData = getParcelableArrayListExtra<SystemTreeBean>("list")
            val list:ArrayList<Fragment> = arrayListOf()
            val titles:ArrayList<String> = arrayListOf()
            for (data in listData?: arrayListOf()){
                list.add(TreeFragment.newInstance(data.id.toString(),null))
                titles.add(data.name?:"")
            }
            binding.viewPager.adapter = CommonFragmentManager(supportFragmentManager,list,titles)
            binding.viewPager.offscreenPageLimit = list.size
            binding.tabLayout.setupWithViewPager(binding.viewPager,false)
        }

    }

    override fun showEmptyLoadingUI(isShow: Boolean) {

    }

    override fun showErrorUI(isShow: Boolean) {

    }
}