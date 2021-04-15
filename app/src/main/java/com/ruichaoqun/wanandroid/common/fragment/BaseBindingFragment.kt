package com.ruichaoqun.wanandroid.common.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.ruichaoqun.wanandroid.R
import com.ruichaoqun.wanandroid.common.ViewBehavior
import com.ruichaoqun.wanandroid.widget.LoadingDialog

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/4/15 9:40
 * @Description:    BaseBindingFragment
 * @Version:        1.0
 */
abstract class BaseBindingFragment<B:ViewDataBinding>:BaseFragment(), ViewBehavior {
    private var _binding:B ?= null
    protected val binding get() = _binding!!


    private  val progressDialog: LoadingDialog by lazy {
        LoadingDialog(requireContext()).apply {
            setMessage(getString(R.string.common_loading))
            setCancelable(false)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showLoading(message: String?) {
        if (!progressDialog.isShowing) {
            progressDialog.apply {
                if(!message.isNullOrEmpty()){
                    setMessage(message)
                }
                show()
            }
        }
    }

    override fun hideLoading() {
        progressDialog.dismiss()
    }

    override fun showEmptyUI(isShow: Boolean) {
    }

    override fun showToast(message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }

    override fun navigate(cls: Class<*>) {
        startActivity(Intent(requireContext(),cls))
    }

    override fun backPress() {
        activity?.onBackPressed()
    }

    override fun finishPage() {
        activity?.finish()
    }
}