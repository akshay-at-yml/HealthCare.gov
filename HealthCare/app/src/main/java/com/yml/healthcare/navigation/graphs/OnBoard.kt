package com.yml.healthcare.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.yml.healthcare.ui.theme.NavigationCommand
import com.yml.launcher.SplashDestination

fun NavGraphBuilder.onBoardingGraph(navController: NavHostController) {
    navigation(
        startDestination = NavigationCommand.Splash.destination,
        route = NavigationCommand.Splash.route
    ) {
        composable(NavigationCommand.Splash.destination) {
            SplashDestination {
                navController.navigate(NavigationCommand.Dashboard.route)
            }
        }
    }
}