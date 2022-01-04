package com.liming.playandroid.base

import android.util.Log
import androidx.fragment.app.Fragment
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener

/**
 * @author pangliming
 *
 */
abstract class BaseFragment : Fragment(), OnLoadMoreListener, OnRefreshListener {
    override fun onLoadMore(refreshLayout: RefreshLayout) {
        Log.e("BaseFragment", "onLoadMore: " )
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        Log.e("BaseFragment", "onRefresh: " )
    }
}