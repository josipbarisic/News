package com.barisic.news.module

import com.barisic.news.repository.NewsRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single { NewsRepository(get()) }
}