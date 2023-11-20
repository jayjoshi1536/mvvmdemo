package com.example.mvvm.utilities

import android.util.Log
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit

object Utils {

    //region To init OKHttp
    fun initOkHttp(): OkHttpClient {
        val cacheSize = 5 * 1024 * 1024 // 5 MiB
        val cacheDirectory = File("/path/to/cache/directory")
        val cache = Cache(cacheDirectory, cacheSize.toLong())

        val requestTimeOut = 300
        val httpClient = OkHttpClient().newBuilder().cache(cache).connectTimeout(requestTimeOut.toLong(), TimeUnit.SECONDS).readTimeout(requestTimeOut.toLong(), TimeUnit.SECONDS).writeTimeout(requestTimeOut.toLong(), TimeUnit.SECONDS)
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addNetworkInterceptor(Interceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val originalHttpUrl = original.url
            val url = originalHttpUrl.newBuilder().build()
            val requestBuilder: Request.Builder = original.newBuilder()
                .header("Content-Type", "application/json")
                .header("Cache-Control", "public, max-age=5")
                .url(url)
            Log.e("API URL", ":$url")
            val request = requestBuilder.build()
            chain.proceed(request)
        })
        httpClient.addInterceptor(interceptor)
        return httpClient.build()
    } //endregion
}