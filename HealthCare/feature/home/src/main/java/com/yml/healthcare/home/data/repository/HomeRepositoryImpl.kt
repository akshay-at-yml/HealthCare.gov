package com.yml.healthcare.home.data.repository

import com.yml.healthcare.home.data.api.HomeAPIService
import com.yml.healthcare.home.domain.model.Article
import com.yml.healthcare.home.domain.repository.HomeRepository
import com.yml.healthcare.home.domain.toArticleList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeAPIService: HomeAPIService
) : HomeRepository {

    override suspend fun fetchHomeData(): List<Article> {
        return withContext(Dispatchers.IO) {
            homeAPIService.getArticles().toArticleList()
        }
    }
}