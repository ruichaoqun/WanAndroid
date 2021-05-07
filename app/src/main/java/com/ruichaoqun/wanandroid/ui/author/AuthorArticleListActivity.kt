package com.ruichaoqun.wanandroid.ui.author

import android.os.Bundle
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.activity.BaseBindingActivity
import com.ruichaoqun.wanandroid.databinding.ActivityAuthorArticleListBinding
import com.ruichaoqun.wanandroid.ui.tree.TreeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorArticleListActivity : BaseBindingActivity<ActivityAuthorArticleListBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_author_article_list
    }

    override fun initialize(savedInstanceState: Bundle?) {
        setSupportActionBar(binding.toolbar)
        val author = intent.getStringExtra("author")
        supportActionBar?.title = "$author 的文章"
        binding.toolbar.setNavigationIcon(R.drawable.ic_back)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        val fragment = TreeFragment.newInstance(null,author)
        supportFragmentManager.beginTransaction().add(R.id.frame_layout,fragment).show(fragment).commit()
    }

    override fun showEmptyLoadingUI(isShow: Boolean) {

    }

    override fun showErrorUI(isShow: Boolean) {

    }
}