package com.barisic.news.repository

import androidx.lifecycle.LiveData
import com.barisic.news.model.Article
import com.barisic.news.network.NewsApiService
import com.barisic.news.util.RequestParams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsRepository(private val newsApiService: NewsApiService) {
    fun getNews(query: String): LiveData<ArrayList<Article>> {
        return object : LiveData<ArrayList<Article>>() {
            override fun onActive() {
                super.onActive()
                GlobalScope.launch(Dispatchers.IO) {
                    val response =
                        newsApiService.getNews(query, RequestParams.getEverythingRequestParams())
                    withContext(Dispatchers.Main) {
                        value = response.articles
                    }
                }
            }
        }
    }
}