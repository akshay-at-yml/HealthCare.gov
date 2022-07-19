package com.yml.healthcare.navigation.graphs

import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.yml.healthcare.navigation.DummyDestination
import com.yml.healthcare.ui.theme.NavigationCommand

fun NavGraphBuilder.dashBoardGraph() {
    navigation(
        startDestination = NavigationCommand.Dashboard.destination,
        route = NavigationCommand.Dashboard.route
    ) {
        composable(NavigationCommand.Dashboard.destination) {
            DummyDestination(color = Color.Blue, title = "DashBoard")
        }
    }
}