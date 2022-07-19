package com.yml.healthcare.navigation.graphs

import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.yml.healthcare.navigation.DummyDestination
import com.yml.healthcare.ui.theme.NavigationCommand


fun NavGraphBuilder.preferencesGraph() {
    navigation(
        startDestination = NavigationCommand.Preferences.destination,
        route = NavigationCommand.Preferences.route
    ) {
        composable(NavigationCommand.Preferences.destination) {
            DummyDestination(color = Color.Cyan, title = "Preference")
        }
    }
}