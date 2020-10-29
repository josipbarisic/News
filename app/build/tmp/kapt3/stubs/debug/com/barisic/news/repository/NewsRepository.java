package com.barisic.news.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/barisic/news/repository/NewsRepository;", "", "newsApiService", "Lcom/barisic/news/network/NewsApiService;", "(Lcom/barisic/news/network/NewsApiService;)V", "getNews", "Landroidx/lifecycle/LiveData;", "Ljava/util/ArrayList;", "Lcom/barisic/news/model/Article;", "Lkotlin/collections/ArrayList;", "query", "", "app_debug"})
public final class NewsRepository {
    private final com.barisic.news.network.NewsApiService newsApiService = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.ArrayList<com.barisic.news.model.Article>> getNews(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    public NewsRepository(@org.jetbrains.annotations.NotNull()
    com.barisic.news.network.NewsApiService newsApiService) {
        super();
    }
}