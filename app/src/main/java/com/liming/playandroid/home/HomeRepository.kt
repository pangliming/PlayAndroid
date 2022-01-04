package com.liming.playandroid.home

import com.liming.playandroid.network.PlayAndroidNetWork
import com.liming.playandroid.util.fire

/**
 * @author pangliming
 *
 */

class HomeRepository {
    fun getBanner() = fire {
        val bannner = PlayAndroidNetWork.getBanner()
        Result.success(bannner)
    }

    fun getArticleList(index:Int) = fire {
        val artists = PlayAndroidNetWork.getHomeArticle(index)
        Result.success(artists)
    }
}