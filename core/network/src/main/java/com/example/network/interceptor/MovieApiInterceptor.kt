package com.example.network.interceptor

import com.example.corenetwork.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class MovieApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader(API_NAME, BuildConfig.MOVIES_API_KEY)
            .build()
        return chain.proceed(request)
    }

    companion object {
        const val API_NAME = "Authorization"
    }
}