package com.liming.playandroid.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.liming.playandroid.bean.BannerBean

/**
 * @author pangliming
 *
 */
class HomePageModel constructor(private val homeRepository: HomeRepository) : ViewModel() {
    private val bannerLiveData = MutableLiveData<List<BannerBean>>()

    fun getBanner() = homeRepository.getBanner()

    fun getArticle(index:Int) = homeRepository.getArticleList(index)

}