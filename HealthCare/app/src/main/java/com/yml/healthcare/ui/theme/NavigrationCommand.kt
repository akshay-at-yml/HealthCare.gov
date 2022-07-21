package com.yml.healthcare.ui.theme

import com.yml.design.bottomNavigation.BottomNavDestination
import com.yml.healthcare.R

sealed class NavigationCommand(
    var route: String,
    var destination: String
) : BottomNavDestination {
    object Splash : NavigationCommand("SplashRoute", "SplashDestination") {
        override fun title(): String {
            return "Launch"
        }
    }

    object Dashboard : NavigationCommand("DashBoardRoute", "DashBoardDestination") {
        override fun title(): String {
            return "Dashboard"
        }

        override fun icon(): Int {
            return com.yml.design.R.drawable.ic_home
        }
    }

    object Preferences : NavigationCommand("PreferenceRoute", "PreferenceDestination") {
        override fun title(): String {
            return "Preferences"
        }

        override fun icon(): Int {
            return com.yml.design.R.drawable.ic_profile
        }
    }

    object Search : NavigationCommand("SearchRoute", "SearchDestination") {
        override fun title(): String {
            return "Search"
        }

        override fun icon(): Int {
            return com.yml.design.R.drawable.ic_search
        }
    }

    object Articles : NavigationCommand("ArticlesRoute", "ArticlesDestination")

    object WebView : NavigationCommand("WebRoute", "WebDestination")
}