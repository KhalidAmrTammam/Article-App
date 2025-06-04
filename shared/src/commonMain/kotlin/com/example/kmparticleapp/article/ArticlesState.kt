package com.example.kmparticleapp.article

data class ArticlesState(
    val articles: List<ArticleRow> = listOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)
