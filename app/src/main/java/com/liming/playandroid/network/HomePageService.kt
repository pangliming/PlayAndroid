package com.liming.playandroid.network

import com.liming.playandroid.bean.ArticleBean
import com.liming.playandroid.bean.ArticleList
import com.liming.playandroid.bean.BannerBean
import com.liming.playandroid.bean.BaseModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author pangliming
 *
 */
interface HomePageService {

    @GET("banner/json")
    suspend fun getBanner(): BaseModel<List<BannerBean>>

    @GET("article/list/{index}/json")
    suspend fun getHomeArticle(@Path("index") index: Int): BaseModel<ArticleList>
}