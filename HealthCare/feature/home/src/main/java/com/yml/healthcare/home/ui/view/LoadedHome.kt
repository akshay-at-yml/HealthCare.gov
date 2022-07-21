package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yml.design.card.HCard
import com.yml.healthcare.home.domain.model.Article

@Composable
fun LoadedHomeScreen(modifier: Modifier, articles: List<Article>) {
    LazyColumn(modifier = modifier) {
        articles.forEach {
            item {
                HCard(title = it.title, description = it.description)
            }
        }
    }
}