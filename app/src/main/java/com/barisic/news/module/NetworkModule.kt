package com.barisic.news.module

import com.barisic.news.network.NewsApiService
import com.barisic.news.util.NEWS_API_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val builder = OkHttpClient.Builder()
        builder.callTimeout(10, TimeUnit.SECONDS)
        builder.addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(NEWS_API_URL)
            .build()
    }
    single { get<Retrofit>().create(NewsApiService::class.java) }
}