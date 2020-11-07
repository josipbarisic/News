package com.barisic.news.repository

import androidx.lifecycle.LiveData
import com.barisic.news.model.Article
import com.barisic.news.model.Source
import com.barisic.news.network.NewsApiService
import com.barisic.news.util.KeyGenerator
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
                        value = response.articles.distinctBy { it.url } as ArrayList<Article>
                    }
                }
            }
        }
    }

    fun getSources(): LiveData<ArrayList<Source>> {
        return object : LiveData<ArrayList<Source>>() {
            override fun onActive() {
                super.onActive()
                GlobalScope.launch(Dispatchers.IO) {
                    val response = newsApiService.getSources(KeyGenerator.getKey())
                    withContext(Dispatchers.Main) {
                        value = response.sources.distinctBy { it.url } as ArrayList<Source>
                    }
                }
            }
        }
    }
}