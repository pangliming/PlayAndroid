package com.liming.playandroid.network

import com.liming.playandroid.bean.BannerBean
import com.liming.playandroid.bean.BaseModel
import retrofit2.http.GET

/**
 * @author pangliming
 *
 */
interface HomePageService {

    @GET("banner/json")
    suspend fun getBanner(): BaseModel<List<BannerBean>>
}