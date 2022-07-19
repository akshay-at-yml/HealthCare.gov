package com.yml.healthcare.ui.theme

import com.yml.design.components.bottomNavigation.BottomNavigation

sealed class NavigationCommand(
    var route: String,
    var destination: String
) : BottomNavigation {
    object Splash : NavigationCommand("SplashRoute", "SplashDestination") {
        override fun title(): String {
            return "Launch"
        }
    }

    object Dashboard : NavigationCommand("DashBoardRoute", "DashBoardDestination") {
        override fun title(): String {
            return "Home"
        }
    }

    object Preferences : NavigationCommand("PreferenceRoute", "PreferenceDestination") {
        override fun title(): String {
            return "Pref"
        }
    }

    object Search : NavigationCommand("SearchRoute", "SearchDestination") {
        override fun title(): String {
            return "Search"
        }
    }
}