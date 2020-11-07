package com.barisic.news.network

import com.barisic.news.model.ArticlesResponse
import com.barisic.news.model.SourcesResponse
import com.barisic.news.util.EVERYTHING
import com.barisic.news.util.SOURCES
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface NewsApiService {
    @GET(EVERYTHING)
    suspend fun getNews(
        @Query("q") q: String,
        @QueryMap requestParams: Map<String, String>
    ): ArticlesResponse

    @GET(SOURCES)
    suspend fun getSources(@Query("apiKey") key: String): SourcesResponse
}