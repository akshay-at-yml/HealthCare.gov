package com.yml.healthcare.home.ui.viewmodel

import com.yml.design.error.ErrorData
import com.yml.healthcare.home.domain.model.Article
import com.yml.healthcare.home.domain.model.HomeDataModel

sealed class HomeViewState(val screenTitle: String = "Home") {
    class UnInitialized : HomeViewState()
    class InitialLoading : HomeViewState()
    class Loaded(val data: HomeDataModel) : HomeViewState()
    class Error(val error: ErrorData) : HomeViewState()
}

sealed class HomeUserIntent {
    object FetchHomeData : HomeUserIntent()
}

sealed class HomeEffect {
    object NavigateToArticleDetail : HomeEffect()

    class SnackMessage(val message: String) : HomeEffect()
}