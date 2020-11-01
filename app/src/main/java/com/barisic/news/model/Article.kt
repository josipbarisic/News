package com.barisic.news.model

import com.barisic.news.util.Common

data class Article(
    val author: String?,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String?
) {
    fun getDate(): String? = Common.convertISOTimeToDate(publishedAt)
}