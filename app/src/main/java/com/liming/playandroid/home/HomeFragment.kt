package com.liming.playandroid.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.liming.playandroid.base.BaseFragment
import com.liming.playandroid.bean.ArticleBean
import com.liming.playandroid.databinding.FragmentHomeBinding
import com.liming.playandroid.widget.HomePageRecyclerViewDivider
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.api.RefreshLayout

/**
 * @author pangliming
 *
 */
class HomeFragment : BaseFragment() {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var homeViewModel: HomePageModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProvider(
            this,
            HomePageViewModelFactory(HomeRepository())
        )[HomePageModel::class.java]
    }

    var index: Int = 0

    private var adapter: HomePageAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initData() {

        adapter = this.activity?.let { a -> HomePageAdapter(a, ArrayList<ArticleBean>()) }
        fragmentHomeBinding.homePageList.adapter = adapter
        homeViewModel.getBanner().observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                val data = it.getOrNull()
                adapter!!.headerData = data!!.data
                adapter!!.notifyItemChanged(0)
            }
        }

        homeViewModel.getArticle(index).observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                val data = it.getOrNull()
                adapter!!.setData(data?.data!!.datas)
                index++
            }
        }
    }

    private fun initView() {
        fragmentHomeBinding.apply {
            val manager = LinearLayoutManager(this@HomeFragment.activity)
            homePageList.layoutManager = manager
            homePageList.addItemDecoration(HomePageRecyclerViewDivider(20))
            refreshLayout.setRefreshHeader(ClassicsHeader(activity))
            refreshLayout.setRefreshFooter(ClassicsFooter(activity))
            refreshLayout.autoRefresh()

            refreshLayout.setOnRefreshListener(this@HomeFragment)
            refreshLayout.setOnLoadMoreListener(this@HomeFragment)

        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        super.onRefresh(refreshLayout)
        if (!fragmentHomeBinding.refreshLayout.isRefreshing) {
            TODO()
        } else {
            fragmentHomeBinding.refreshLayout.finishRefresh()
        }

    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        super.onLoadMore(refreshLayout)
        homeViewModel.getArticle(index).observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                val data = it.getOrNull()
                if (data == null) {
                    fragmentHomeBinding.refreshLayout.finishLoadMoreWithNoMoreData()
                    return@observe
                }
                adapter!!.setData(data.data.datas)
                index++
                fragmentHomeBinding.refreshLayout.finishLoadMore(1000)

            } else {
                fragmentHomeBinding.refreshLayout.finishLoadMoreWithNoMoreData()
            }
        }
    }
}