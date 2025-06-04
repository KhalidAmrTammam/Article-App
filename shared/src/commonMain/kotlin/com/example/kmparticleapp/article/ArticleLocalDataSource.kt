package com.example.kmparticleapp.article

import sqldelight.articles.db.ArticlesDatabase

class ArticleLocalDataSource(
    private val database: ArticlesDatabase
) {
    fun getAllArticles(): List<ArticleRow>{
        return database.articlesDatabaseQueries.selectAllArticles(::mapToArticle).executeAsList()
    }

    private fun mapToArticle(
        title: String?,
        desc: String?,
        date: String?,
        imgUrl: String?
    ) : ArticleRow {
        return ArticleRow(
            title = title ?: "",
            description = desc ?: "",
            publishedAt = date ?: "",
            urlToImage = imgUrl ?: ""
        )
    }

    fun insertAllArticles(articles: List<ArticleRow>){
        database.articlesDatabaseQueries.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }
    }

    fun insertArticle(article: ArticleRow) {
        database.articlesDatabaseQueries.insertArticle(
            article.title ?: "",
            article.description ?: "",
            article.publishedAt ?: "",
            article.urlToImage ?: ""
        )

    }


}
