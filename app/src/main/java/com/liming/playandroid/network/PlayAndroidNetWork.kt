package com.liming.playandroid.network

/**
 * @author pangliming
 *
 */
object PlayAndroidNetWork {
    private val homePageService = ServiceCreator.create(HomePageService::class.java)
    suspend fun getBanner() = homePageService.getBanner()
}