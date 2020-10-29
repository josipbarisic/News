package com.barisic.news.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\'\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/barisic/news/viewmodel/NewsViewModel;", "Landroidx/lifecycle/ViewModel;", "newsRepo", "Lcom/barisic/news/repository/NewsRepository;", "(Lcom/barisic/news/repository/NewsRepository;)V", "query", "Landroidx/lifecycle/MutableLiveData;", "", "getQuery", "()Landroidx/lifecycle/MutableLiveData;", "result", "Landroidx/lifecycle/LiveData;", "Ljava/util/ArrayList;", "Lcom/barisic/news/model/Article;", "Lkotlin/collections/ArrayList;", "getResult", "()Landroidx/lifecycle/LiveData;", "app_debug"})
public final class NewsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> query = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.ArrayList<com.barisic.news.model.Article>> result = null;
    private final com.barisic.news.repository.NewsRepository newsRepo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.ArrayList<com.barisic.news.model.Article>> getResult() {
        return null;
    }
    
    public NewsViewModel(@org.jetbrains.annotations.NotNull()
    com.barisic.news.repository.NewsRepository newsRepo) {
        super();
    }
}