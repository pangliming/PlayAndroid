package com.liming.playandroid.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author pangliming
 *
 */
object ServiceCreator {
    //const 声明常量 仅限于在top-level或object中
    private const val BASE_URL = "https://www.wanandroid.com"

    //连接超时时间
    private const val CONNECT_TIMEOUT = 30L

    //读取超时时间
    private const val READ_TIMEOUT = 10L

    private fun create(): Retrofit {
        //配置OKHttp
        val okHttpClient = OkHttpClient.Builder()
            .apply {
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            }.build()
        //创建Retrofit
        return RetrofitBuild(BASE_URL, okHttpClient, GsonConverterFactory.create()).retrofit
    }

    /*get ServiceApi*/
    fun <T> create(service: Class<T>): T = create().create(service)
}

class RetrofitBuild(url: String, okHttpClient: OkHttpClient, gsonFactory: GsonConverterFactory) {
    val retrofit: Retrofit = Retrofit.Builder().apply {
        baseUrl(url)
        client(okHttpClient)
        addConverterFactory(gsonFactory)
    }.build()
}