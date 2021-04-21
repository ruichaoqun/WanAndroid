package com.ruichaoqun.wanandroid

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager
import com.ruichaoqun.wanandroid.ui.dashboard.DashboardFragment
import com.ruichaoqun.wanandroid.ui.home.HomeFragment
import com.ruichaoqun.wanandroid.ui.notifications.NotificationsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var pager: ViewPager
    lateinit var home: TextView
    lateinit var dashboard: TextView
    lateinit var notifications: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager = findViewById(R.id.view_pager)
        home = findViewById(R.id.tv_home)
        dashboard = findViewById(R.id.tv_dashboard)
        notifications = findViewById(R.id.tv_notifications)
        pager.adapter = Adapter(supportFragmentManager)
        pager.offscreenPageLimit = 3
        pager.addOnPageChangeListener(object :
            ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                updateText(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
        home.setOnClickListener {
            pager.currentItem = 0
        }
        dashboard.setOnClickListener {
            pager.currentItem = 1
        }
        notifications.setOnClickListener {
            pager.currentItem = 2
        }
    }

    private fun updateText(position: Int) {
        home.setTextColor(if (position == 0) getColor(R.color.color_178FFF) else getColor(R.color.color_707070))
        home.compoundDrawableTintList =
            ColorStateList.valueOf(if (position == 0) getColor(R.color.color_178FFF) else getColor(R.color.color_707070))
        dashboard.setTextColor(if (position == 1) getColor(R.color.color_178FFF) else getColor(R.color.color_707070))
        dashboard.compoundDrawableTintList =
            ColorStateList.valueOf(if (position == 1) getColor(R.color.color_178FFF) else getColor(R.color.color_707070))
        notifications.setTextColor(if (position == 2) getColor(R.color.color_178FFF) else getColor(R.color.color_707070))
        notifications.compoundDrawableTintList =
            ColorStateList.valueOf(if (position == 2) getColor(R.color.color_178FFF) else getColor(R.color.color_707070))
    }

    class Adapter(manager: FragmentManager) :
        FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        companion object{
            val fragments:List<Fragment> = listOf(HomeFragment(),DashboardFragment(),NotificationsFragment())
        }

        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }
    }
}