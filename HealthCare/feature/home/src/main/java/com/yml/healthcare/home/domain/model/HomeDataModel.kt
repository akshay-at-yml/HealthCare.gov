package com.yml.healthcare.home.domain.model

data class Article(
    val title: String,
    val description: String,
    val tags: List<String>,
    val url: String
)