package com.liming.playandroid.bean

/**
 * @author pangliming
 * 首页Banner
 */
data class BannerBean(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)
