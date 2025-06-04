package com.example.kmparticleapp.article

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val ktorClient: HttpClient) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "0fbcbdb25e4d46f8acd012f14878aa85"

    suspend fun fetchArticles(): List<ArticleRow> {
        val response: ArticlesResponse =
            ktorClient
                .get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body()
        return response.articles ?: emptyList()
    }
}