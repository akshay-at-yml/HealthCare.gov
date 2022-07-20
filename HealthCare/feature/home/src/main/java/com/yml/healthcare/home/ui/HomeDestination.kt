package com.yml.healthcare.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.yml.design.error.ErrorWidget
import com.yml.design.error.FullScreenError
import com.yml.healthcare.home.viewmodel.HomeEffect
import com.yml.healthcare.home.viewmodel.HomeUserIntent
import com.yml.healthcare.home.viewmodel.HomeViewModel
import com.yml.healthcare.home.viewmodel.HomeViewState
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

    fun handleEffects(homeEffect: HomeEffect) {
        // handle nav effects / show snack bar kind of implementations
    }

    LaunchedEffect(Unit) {
        effect.collect {
            handleEffects(it)
        }
    }

    when (val state = viewState.value) {
        is HomeViewState.Error -> {
            FullScreenError(data = state.error, screenTitle = "Home")
        }
        HomeViewState.InitialLoading -> {
            FullScreenError(screenTitle = "Home")
        }
        is HomeViewState.Loaded -> {
            FullScreenError(screenTitle = "Home")
        }
        HomeViewState.UnInitialized -> {
            userIntent(HomeUserIntent.FetchHomeData)
        }
    }

}
