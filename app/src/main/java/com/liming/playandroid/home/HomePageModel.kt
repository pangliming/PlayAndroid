package com.liming.playandroid.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.liming.playandroid.base.BannerBean
import com.liming.playandroid.base.BaseModel

/**
 * @author pangliming
 *
 */
class HomePageModel constructor(private val homeRepository: HomeRepository) : ViewModel() {
    private val bannerLiveData = MutableLiveData<List<BannerBean>>()

    fun getBanner() = Transformations.switchMap(bannerLiveData){
        homeRepository.getBanner()
    }

}