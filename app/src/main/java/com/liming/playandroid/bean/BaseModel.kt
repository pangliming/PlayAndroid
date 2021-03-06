package com.liming.playandroid.bean

/**
 * @author pangliming
 *
 */
data class BaseModel<T>(
    val `data`: T,
    val errorCode: Int,
    val errorMsg: String,
    val viewType: Int
)
