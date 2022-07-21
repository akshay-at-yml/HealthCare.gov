package com.yml.healthcare.navigation.graphs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.yml.healthcare.home.ui.HomeDestination
import com.yml.healthcare.home.ui.viewmodel.HomeViewModel
import com.yml.healthcare.ui.theme.NavigationCommand

fun NavGraphBuilder.dashBoardGraph() {
    navigation(
        startDestination = NavigationCommand.Dashboard.destination,
        route = NavigationCommand.Dashboard.route
    ) {
        composable(NavigationCommand.Dashboard.destination) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeDestination(viewModel = viewModel)
        }
    }
}