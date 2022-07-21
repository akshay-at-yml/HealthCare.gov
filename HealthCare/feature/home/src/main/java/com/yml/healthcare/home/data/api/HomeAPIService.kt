package com.yml.healthcare.home.data.api

import com.yml.healthcare.home.data.model.ArticleListDTO
import retrofit2.http.GET

interface HomeAPIService {

    @GET("/api/articles.json")
    suspend fun getArticles(): ArticleListDTO
}