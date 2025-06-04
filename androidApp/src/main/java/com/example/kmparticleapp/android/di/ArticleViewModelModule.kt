package com.example.kmparticleapp.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmparticleapp.article.ArticleViewModel
import com.example.kmparticleapp.database.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sqldelight.articles.db.ArticlesDatabase
import sqldelight.articles.db.ArticlesDatabase.Companion.invoke


val viewModelModule = module {
    viewModel { ArticleViewModel(get()) }
}

val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory(androidContext()).createDriver() }
    single<ArticlesDatabase> { ArticlesDatabase(get()) }
}