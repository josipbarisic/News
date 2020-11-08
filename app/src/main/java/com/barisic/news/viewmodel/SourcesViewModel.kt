package com.barisic.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.barisic.news.model.Source
import com.barisic.news.repository.NewsRepository

class SourcesViewModel(private val newsRepo: NewsRepository) : ViewModel() {
    val sourcesResult: LiveData<ArrayList<Source>> = newsRepo.getSources()
}