package com.barisic.news.network

import com.barisic.news.model.NewsApiResponse
import com.barisic.news.util.EVERYTHING
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface NewsApiService {
    @GET(EVERYTHING)
    suspend fun getNews(
        @Query("q") q: String,
        @QueryMap requestParams: Map<String, String>
    ): NewsApiResponse
}