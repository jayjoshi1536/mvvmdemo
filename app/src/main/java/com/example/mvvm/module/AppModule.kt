package com.example.mvvm.module

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.example.mvvm.api.ApiClient
import com.example.mvvm.repository.UserRepository
import com.example.mvvm.repository.UserRepositoryImpl
import com.example.mvvm.utilities.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module @InstallIn(SingletonComponent::class) class AppModule {

    //region Normal
    @Provides @Singleton @Named("Normal") fun providesRetrofit(): Retrofit {
        return requestUrl()
    }

    @Provides @Singleton @Named("NormalApi") fun providesApi(@Named("Normal") retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    @Provides @Singleton fun providesUserRepository(@Named("NormalApi") api: ApiClient): UserRepository {
        return UserRepositoryImpl(api)
    }

    //region To prepare request
    private var okHttpClient: OkHttpClient? = null

    private fun requestUrl(): Retrofit {
        val url = "https://dummyjson.com/"
        if (okHttpClient == null) okHttpClient = Utils.initOkHttp()
        return Retrofit.Builder().baseUrl(url).client(okHttpClient!!).addConverterFactory(ScalarsConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build()
    }
    //endregion
}