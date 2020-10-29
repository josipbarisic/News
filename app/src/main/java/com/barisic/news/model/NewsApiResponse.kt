package com.barisic.news.model

data class NewsApiResponse(
    val status: String,
    val totalResults: Int,
    val articles: ArrayList<Article>
)