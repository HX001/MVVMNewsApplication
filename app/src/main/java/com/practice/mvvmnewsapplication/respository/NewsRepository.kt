package com.practice.mvvmnewsapplication.respository

import com.practice.mvvmnewsapplication.api.RetrofitInstance
import com.practice.mvvmnewsapplication.db.ArticleDataBase
import com.practice.mvvmnewsapplication.models.Article

class NewsRepository(
    private val db: ArticleDataBase
) {
    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) =
        db.getArticleDao().upsert(article)

    fun getFavoriteArticles() =
        db.getArticleDao().getAllArticles()

    suspend fun deleteArticles(article: Article) =
        db.getArticleDao().deleteArticles(article)
}