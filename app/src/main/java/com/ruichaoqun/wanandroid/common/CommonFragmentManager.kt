package com.ruichaoqun.wanandroid.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/5/7 14:35
 * @Description:    CommonFragmentManager
 * @Version:        1.0
 */
class CommonFragmentManager(manager: FragmentManager,var fragments:List<Fragment>,var titles:List<String> ?= null):  FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles?.get(position)
    }

    override fun getPageWidth(position: Int): Float {
        return super.getPageWidth(position)
    }
}