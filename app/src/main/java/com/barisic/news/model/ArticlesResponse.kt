package com.barisic.news.model

data class ArticlesResponse(
    val status: String,
    val totalResults: Int,
    val articles: ArrayList<Article>
)