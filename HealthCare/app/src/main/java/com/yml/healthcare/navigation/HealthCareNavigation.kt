package com.yml.healthcare.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yml.healthcare.navigation.graphs.dashBoardGraph
import com.yml.healthcare.navigation.graphs.onBoardingGraph
import com.yml.healthcare.navigation.graphs.preferencesGraph
import com.yml.healthcare.navigation.graphs.searchGraph
import com.yml.healthcare.ui.theme.NavigationCommand
import com.yml.launcher.SplashDestination

@Composable
fun HealthcareNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationCommand.Splash.route
    ) {
//        onBoardingGraph(navController)
        dashBoardGraph()
        preferencesGraph()
        searchGraph()

        composable(NavigationCommand.Splash.route) {
            SplashDestination {
                navController.popBackStack() // splash should not be there in the back stack
                navController.navigate(NavigationCommand.Dashboard.route)
            }
        }
    }
}

@Composable
fun DummyDestination(color: Color, title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = title, style = TextStyle(color = Color.White))
    }
}