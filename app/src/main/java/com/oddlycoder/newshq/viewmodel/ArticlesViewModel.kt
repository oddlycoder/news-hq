package com.oddlycoder.newshq.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.oddlycoder.newshq.model.Article
import com.oddlycoder.newshq.model.News
import com.oddlycoder.newshq.model.repository.Repository

class ArticlesViewModel : ViewModel() {

    private val repository: Repository = Repository

    private var articlesLiveData = MutableLiveData<List<Article>>()
    private var articlesList = mutableListOf<Article>()

    fun articlesList(): List<Article> {
        return articlesList
    }

    // articles news result
    fun allArticles(): MutableLiveData<List<Article>> {
        articlesLiveData = repository.getArticles() as MutableLiveData<List<Article>>
        //return repository.getArticles() as MutableLiveData<List<Article>>
        articlesList.let {
            articlesLiveData
        }
        return articlesLiveData
    }

    fun articleCall(): LiveData<Boolean> {
        return repository.getArticleCallFailed()
    }

}