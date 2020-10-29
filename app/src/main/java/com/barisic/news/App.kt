package com.barisic.news

import android.app.Application
import com.barisic.news.module.networkModule
import com.barisic.news.module.repositoriesModule
import com.barisic.news.module.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(this@App)
            loadKoinModules(
                listOf(
                    networkModule,
                    repositoriesModule,
                    viewModelsModule
                )
            )
        }
    }
}