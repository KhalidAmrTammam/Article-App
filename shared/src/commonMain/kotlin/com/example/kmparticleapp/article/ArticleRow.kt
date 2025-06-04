package com.example.kmparticleapp.article

import kotlinx.serialization.Serializable

@Serializable
data class ArticleRow(
    val title: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val urlToImage: String = ""
)

