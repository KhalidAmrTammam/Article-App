package com.example.kmparticleapp.android

import android.app.Application
import com.example.kmparticleapp.android.di.databaseModule
import com.example.kmparticleapp.android.di.viewModelModule
import com.example.kmparticleapp.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.collections.plus

class ArticleApplication: Application()  {
    override fun onCreate() {
        super.onCreate()
        initKoin();
    }

    private fun initKoin() {
        val allModules = sharedKoinModule + viewModelModule + databaseModule
        startKoin {
            androidContext(this@ArticleApplication)
            modules(allModules)
        }
    }
}