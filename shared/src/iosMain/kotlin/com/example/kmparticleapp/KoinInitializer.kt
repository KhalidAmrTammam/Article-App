package com.example.kmparticleapp


import com.example.kmparticleapp.article.ArticleViewModel
import com.example.kmparticleapp.di.sharedKoinModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val allModules = sharedKoinModule
    startKoin {
        modules(allModules)
    }
}
class ArticleInjector : KoinComponent {
    val articleViewModel : ArticleViewModel by inject()
}