package com.yml.healthcare.navigation.graphs

import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.yml.healthcare.navigation.DummyDestination
import com.yml.healthcare.ui.theme.NavigationCommand

fun NavGraphBuilder.onBoardingGraph() {
    navigation(
        startDestination = NavigationCommand.Splash.destination,
        route = NavigationCommand.Splash.route
    ) {
        composable(NavigationCommand.Splash.destination) {
            DummyDestination(color = Color.Green, title = "Launch")
        }
    }
}