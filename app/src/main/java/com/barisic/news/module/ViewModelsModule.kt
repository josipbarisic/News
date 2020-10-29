package com.barisic.news.module

import com.barisic.news.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { NewsViewModel(get()) }
}