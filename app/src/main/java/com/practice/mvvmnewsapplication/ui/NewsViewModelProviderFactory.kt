package com.practice.mvvmnewsapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.mvvmnewsapp.ui.NewsViewModel
import com.practice.mvvmnewsapplication.respository.NewsRepository

class NewsViewModelProviderFactory(
    private val newsRepository: NewsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return modelClass.getConstructor(NewsRepository::class.java)
//            .newInstance(newsRepository)
        return NewsViewModel(newsRepository) as T
    }
}