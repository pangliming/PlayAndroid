package com.liming.playandroid.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liming.playandroid.bean.BannerBean
import com.liming.playandroid.databinding.ItemHomeBannerBinding
import com.youth.banner.adapter.BannerAdapter

/**
 * @author pangliming
 *
 */
class HomePageBannerAdapter @JvmOverloads constructor(
    private val data: List<BannerBean>,
    private val context: Context
) :
    BannerAdapter<BannerBean, HomePageBannerAdapter.BannerViewHolder>(data) {

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
        val binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(context), parent, false
        )
        return BannerViewHolder(binding)
    }

    override fun onBindView(
        holder: BannerViewHolder?,
        data: BannerBean?,
        position: Int,
        size: Int
    ) {
        holder?.binding?.ivBanner?.let { Glide.with(context).load(data?.imagePath).into(it) }
    }

    class BannerViewHolder(val binding: ItemHomeBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}