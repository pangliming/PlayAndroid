package com.liming.playandroid.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.liming.playandroid.base.BaseRecyclerAdapter
import com.liming.playandroid.bean.ArticleBean
import com.liming.playandroid.bean.BannerBean
import com.liming.playandroid.constant.ViewTypes
import com.liming.playandroid.databinding.HomePageBannerBinding
import com.liming.playandroid.databinding.HomePageListItemBinding
import com.liming.playandroid.util.getHtml

/**
 * @author pangliming
 *
 */
class HomePageAdapter(val context: Context, val data: ArrayList<ArticleBean>) :
    BaseRecyclerAdapter<ViewBinding>() {


    var headerData: List<BannerBean>? = null
    fun setData(data: List<ArticleBean>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerAdapter.BaseRecyclerViewHolder<ViewBinding> {
        return when (viewType) {
            ViewTypes.HOME_PAGE_BANNER -> {
                val binding =
                    HomePageBannerBinding.inflate(LayoutInflater.from(context), parent, false)
                BaseRecyclerViewHolder(binding)
            }

            else -> {
                val binding =
                    HomePageListItemBinding.inflate(LayoutInflater.from(context), parent, false)
                BaseRecyclerViewHolder(binding)
            }
        }


    }

    override fun onBaseBindViewHolder(position: Int, binding: ViewBinding) {
        when (getItemViewType(position)) {
            ViewTypes.HOME_PAGE_BANNER -> {
                convertBanner(
                    headerData!!,
                    binding as HomePageBannerBinding
                )
            }

            else -> {
                var count = if (headerData != null) {
                    position - 1
                } else {
                    position
                }
                convertArticleList(data = data[count], binding as HomePageListItemBinding)
            }
        }
    }

    override fun getItemCount(): Int {
        var count = data?.size ?: 0
        if (headerData != null) {
            count++
        }
        return count
    }

    override fun getItemViewType(position: Int): Int {

        if (headerData != null && position == 0) {
            return ViewTypes.HOME_PAGE_BANNER
        }
        return ViewTypes.HOME_PAGE_LIST
    }

    private fun convertBanner(data: List<BannerBean>, binding: HomePageBannerBinding) {

        binding.homeBanner.adapter = HomePageBannerAdapter(context = context, data = data)
    }

    private fun convertArticleList(data: ArticleBean, binding: HomePageListItemBinding) {
        binding.authorOrSharer.text = if (data.author.isEmpty()) {
            data.shareUser
        } else {
            data.author
        }
        binding.shareTimeTv.text = data.niceDate
        binding.titleTv.text = getHtml(data.title)
        binding.chapterName.text = data.superChapterName
    }
}