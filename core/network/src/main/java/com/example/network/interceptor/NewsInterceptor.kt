package com.example.network.interceptor

import com.example.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class NewsInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader(API_NAME, BuildConfig.NEWS_API_KEY)
            .build()
        return chain.proceed(request)
    }

    companion object {
        const val API_NAME = "X-Api-Key"
    }
}