package com.example.kmparticleapp.di

import com.example.kmparticleapp.article.ArticleLocalDataSource
import com.example.kmparticleapp.article.ArticleViewModel
import com.example.kmparticleapp.article.ArticlesService
import com.example.kmparticleapp.repo.ArticleRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    coerceInputValues = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}

val articleModule = module {
    single { ArticlesService(get()) }
    single { ArticleLocalDataSource(get()) }
    single { ArticleRepository(get(),get()) }
    single { ArticleViewModel(get()) }
}

val sharedKoinModule = listOf(
    networkModule,
    articleModule
)