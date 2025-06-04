package com.example.kmparticleapp.repo

import com.example.kmparticleapp.article.ArticleLocalDataSource
import com.example.kmparticleapp.article.ArticleRow
import com.example.kmparticleapp.article.ArticlesService

class ArticleRepository(
    private val articlesService: ArticlesService,
    private val database: ArticleLocalDataSource
    ) {
    suspend fun fetchArticles(): List<ArticleRow> {

        val articlesDb = database.getAllArticles()
        println("articlesDb: ${articlesDb.size}")
        if (articlesDb.isEmpty()) {
            val fetchedArticles = articlesService.fetchArticles()
            database.insertAllArticles(fetchedArticles)
            return fetchedArticles
        }
        return articlesDb
    }
}