package com.yml.healthcare.home.viewmodel

import com.yml.design.error.ErrorData

sealed class HomeViewState {
    object UnInitialized : HomeViewState()
    object InitialLoading : HomeViewState()
    class Loaded : HomeViewState()
    class Error(val error: ErrorData) : HomeViewState()
}

sealed class HomeUserIntent {
    object FetchHomeData : HomeUserIntent()
}

sealed class HomeEffect {
    object NavigateToArticleDetail : HomeEffect()

    class SnackMessage(message: String) : HomeEffect()
}