package com.example.kmparticleapp.article

import com.example.kmparticleapp.BaseViewModel
import com.example.kmparticleapp.repo.ArticleRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(private var articleRepository: ArticleRepository): BaseViewModel(){

    private var _articleStateFlow = MutableStateFlow(ArticlesState(isLoading = true))
    val articleStateFlow = _articleStateFlow.asStateFlow()


    init {
        getAllArticles()
    }

    private fun getAllArticles(){
        scope.launch {
            delay(2000)
            _articleStateFlow.value = ArticlesState(error = "error")
            delay(2000)
            val fetchArticles = articleRepository.fetchArticles()
            _articleStateFlow.value = ArticlesState(articles = fetchArticles)
        }
    }
}
