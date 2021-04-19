package com.ruichaoqun.wanandroid.ui.notifications

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

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        Log.w("AAAAA","NotificationsFragment  onCreateView")
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.w("AAAAA","HomeFragment  onCreate")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.w("AAAAA","NotificationsFragment  onViewCreated")
    }

    override fun onResume() {
        super.onResume()
        Log.w("AAAAA","NotificationsFragment  onResume")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.w("AAAAA","NotificationsFragment  onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("AAAAA","NotificationsFragment  onDestroy")
    }
}