package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.yml.design.error.ErrorData
import com.yml.design.error.ErrorWidget
import com.yml.design.toolbar.HCToolBarScreen
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

    fun handleEffects(homeEffect: HomeEffect) {
        // handle nav effects / show snack bar kind of implementations
    }

    LaunchedEffect(Unit) {
        effect.collect {
            handleEffects(it)
        }
    }
    val state = viewState.value

    HCToolBarScreen(
        title = state.screenTitle,
        modifier = Modifier.background(color = Color.White)
    ) {
        when (state) {
            is HomeViewState.Error -> {
                ErrorWidget(
                    data = state.error, modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                )
            }
            is HomeViewState.InitialLoading -> {
                ErrorWidget(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White), data = ErrorData.mockData
                )
            }

            is HomeViewState.Loaded -> {
                LoadedHomeScreen(it, state.list)
            }

            is HomeViewState.UnInitialized -> {
                userIntent(HomeUserIntent.FetchHomeData)
            }
        }
    }
}
