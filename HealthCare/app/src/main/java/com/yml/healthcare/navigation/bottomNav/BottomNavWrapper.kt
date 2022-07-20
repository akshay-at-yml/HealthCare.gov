package com.yml.healthcare.navigation.bottomNav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.yml.design.components.bottomNavigation.HealthCareBottomNavigation
import com.yml.healthcare.ui.theme.NavigationCommand

@Composable
fun HealthCareBottomNavWrapper(navHostController: NavHostController) {
    val destinations = remember { bottomNavDestinations() }
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    HealthCareBottomNavigation(
        isSelected = { it.route == currentDestination?.route },
        items = destinations
    ) {
        navHostController.navigate(route = it.route)
    }
}

private fun bottomNavDestinations() = listOf(
    NavigationCommand.Dashboard,
    NavigationCommand.Splash,
    NavigationCommand.Search,
    NavigationCommand.Preferences
)