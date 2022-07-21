package com.yml.healthcare.ui.theme

import com.yml.design.bottomNavigation.BottomNavDestination


/**
 * Represents Nav Graph routes
 */
sealed class GraphRoute(val route: String) {
    object Root : GraphRoute("RootGraph")
    object Home : GraphRoute("HomeGraph")
    object Search : GraphRoute("SearchGraph")
    object Settings : GraphRoute("SettingsGraph")
}

/**
 * Represents Each screen routes
 */
sealed class NavigationCommand(
    // route represents each destinations
    var route: String
) : BottomNavDestination {
    object Splash : NavigationCommand("SplashRoute") {
        override fun title(): String {
            return "Launch"
        }
    }

    object Dashboard : NavigationCommand("DashBoardRoute") {
        override fun title(): String {
            return "Dashboard"
        }

        override fun icon(): Int {
            return com.yml.design.R.drawable.ic_home
        }
    }

    object Preferences : NavigationCommand("PreferenceRoute") {
        override fun title(): String {
            return "Preferences"
        }

        override fun icon(): Int {
            return com.yml.design.R.drawable.ic_profile
        }
    }

    object Search : NavigationCommand("SearchRoute") {
        override fun title(): String {
            return "Search"
        }

        override fun icon(): Int {
            return com.yml.design.R.drawable.ic_search
        }
    }

    object Articles : NavigationCommand("ArticlesRoute")

    object WebView : NavigationCommand("WebRoute")
}