package com.yml.healthcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDirections
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.yml.healthcare.ui.theme.HealthCareTheme
import com.yml.healthcare.ui.theme.NavigationCommand

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            HealthCareTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(bottomBar = {
                        val items = remember { createList() }
                        HealthCareBottomNavigation(navController, items)
                    }) {
                        NavHost(
                            navController = navController,
                            startDestination = NavigationCommand.Splash.route
                        ) {
                            onBoardingGraph()
                            dashBoardGraph()
                            preferencesGraph()
                            searchGraph()
                        }
                    }
                }
            }
        }
    }

    private fun NavGraphBuilder.dashBoardGraph() {
        navigation(
            startDestination = NavigationCommand.Dashboard.destination,
            route = NavigationCommand.Dashboard.route
        ) {
            composable(NavigationCommand.Dashboard.destination) {
                DummyDestination(color = Color.Blue, title = "DashBoard")
            }
        }
    }

    private fun NavGraphBuilder.preferencesGraph() {
        navigation(
            startDestination = NavigationCommand.Preferences.destination,
            route = NavigationCommand.Preferences.route
        ) {
            composable(NavigationCommand.Preferences.destination) {
                DummyDestination(color = Color.Cyan, title = "Preference")
            }
        }
    }

    private fun NavGraphBuilder.searchGraph() {
        navigation(
            startDestination = NavigationCommand.Search.destination,
            route = NavigationCommand.Search.route
        ) {
            composable(NavigationCommand.Search.destination) {
                DummyDestination(color = Color.Magenta, title = "Search")
            }
        }
    }

    private fun NavGraphBuilder.onBoardingGraph() {
        navigation(
            startDestination = NavigationCommand.Splash.destination,
            route = NavigationCommand.Splash.route
        ) {
            composable(NavigationCommand.Splash.destination) {
                DummyDestination(color = Color.Green, title = "Launch")
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        HealthCareTheme {
            Greeting("Android")
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


    @Composable
    fun HealthCareBottomNavigation(
        navController: NavHostController,
        items: List<NavigationCommand>
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        BottomNavigation {
            items.forEach {
                BottomNavigationItem(
                    icon = {
                        Label(it.title())
                    },
                    label = {
                    },
                    selected = currentDestination == it,
                    alwaysShowLabel = true, // This hides the title for the unselected items
                    onClick = {
                        navController.navigate(route = it.destination)
                    },
                )
            }
        }

    }

    private fun createList() = listOf(
        NavigationCommand.Dashboard,
        NavigationCommand.Splash,
        NavigationCommand.Search,
        NavigationCommand.Preferences
    )


    @Composable
    private fun Label(value: String) {
        Text(text = value)
    }
}