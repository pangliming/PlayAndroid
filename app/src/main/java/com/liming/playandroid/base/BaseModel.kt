package com.liming.playandroid.base

/**
 * @author pangliming
 *
 */
data class BaseModel<T>(
    val `data`: T,
    val errorCode: Int,
    val errorMsg: String
)
