package com.yml.healthcare.home.domain

import android.text.Html
import androidx.core.text.HtmlCompat
import com.yml.core.utils.orEmpty
import com.yml.healthcare.home.data.model.ArticleDTO
import com.yml.healthcare.home.data.model.ArticleListDTO
import com.yml.healthcare.home.domain.model.Article

fun ArticleListDTO.toArticleList(): List<Article> {
    return articles?.let { list ->
        list.map { it.toArticle() }
    } ?: listOf()
}

fun ArticleDTO.toArticle(): Article {
    return Article(
        title = title.orEmpty(),
        tags = tags ?: listOf(),
        url = url.orEmpty(),
        description = HtmlCompat.fromHtml(content.orEmpty(), 0).toString()
    )
}