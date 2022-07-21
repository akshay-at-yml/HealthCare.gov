package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.yml.design.container.HCToolBarScreen
import com.yml.design.error.ErrorWidget
import com.yml.design.progress.HCProgressBar
import com.yml.healthcare.home.R
import com.yml.healthcare.home.ui.viewmodel.HomeEffect
import com.yml.healthcare.home.ui.viewmodel.HomeUserIntent
import com.yml.healthcare.home.ui.viewmodel.HomeViewModel
import com.yml.healthcare.home.ui.viewmodel.HomeViewState
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeDestination(viewModel: HomeViewModel) {
    val homeState = viewModel.viewState.collectAsState()
    HomeDestination(
        viewState = homeState,
        effect = viewModel.homeEffect
    ) {
        viewModel.performAction(it)
    }
}

@Composable
private fun HomeDestination(
    viewState: State<HomeViewState>,
    effect: Flow<HomeEffect>,
    userIntent: (HomeUserIntent) -> Unit
) {
    val state = viewState.value
    HCToolBarScreen(
        title = state.screenTitle,
        leftIcon = com.yml.design.R.drawable.ic_menu_burger,
        headerImage = R.drawable.health_care_gov,
        modifier = Modifier.background(color = Color.White)
    ) { modifier, snackMessage ->

        fun handleEffects(homeEffect: HomeEffect) {
            when (homeEffect) {
                HomeEffect.NavigateToArticleDetail -> TODO()
                is HomeEffect.SnackMessage -> {
                    snackMessage(homeEffect.message)
                }
            }
        }

        LaunchedEffect(Unit) {
            effect.collect {
                handleEffects(it)
            }
        }

        when (state) {
            is HomeViewState.Error -> {
                ErrorWidget(
                    data = state.error, modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                )
            }
            is HomeViewState.InitialLoading -> {
                HCProgressBar()
            }

            is HomeViewState.Loaded -> {
                LoadedHomeScreen(modifier, state.list)
            }

            is HomeViewState.UnInitialized -> {
                userIntent(HomeUserIntent.FetchHomeData)
            }
        }
    }
}
