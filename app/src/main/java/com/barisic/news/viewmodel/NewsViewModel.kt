package com.barisic.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.barisic.news.model.Article
import com.barisic.news.model.Source
import com.barisic.news.repository.NewsRepository

class NewsViewModel(private val newsRepo: NewsRepository) : ViewModel() {
    val query = MutableLiveData<String>("2020 Elections")
    val result: LiveData<ArrayList<Article>> = Transformations.switchMap(query) {
        if (it.length > 4) newsRepo.getNews(it) else null
    }
    val bottomWebViewUrl = MutableLiveData<String?>()
    val showArticleContent = MutableLiveData(false)

    val sourcesResult: LiveData<ArrayList<Source>> = newsRepo.getSources()
}