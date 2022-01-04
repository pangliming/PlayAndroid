package com.liming.playandroid.bean

data class ArticleList(
    val curPage: Int,
    val datas: List<ArticleBean>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)