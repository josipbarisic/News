package com.barisic.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.barisic.news.model.Article
import com.barisic.news.repository.NewsRepository

class NewsViewModel(private val newsRepo: NewsRepository) : ViewModel() {
    val query = MutableLiveData<String>("Election")
    val result: LiveData<ArrayList<Article>> = Transformations.switchMap(query) {
        if (it.length > 4) newsRepo.getNews(it) else null
    }
}