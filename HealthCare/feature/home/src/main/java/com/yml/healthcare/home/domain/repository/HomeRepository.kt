package com.yml.healthcare.home.domain.repository

import com.yml.healthcare.home.domain.model.Article

interface HomeRepository {
    suspend fun fetchHomeData(): List<Article>
}