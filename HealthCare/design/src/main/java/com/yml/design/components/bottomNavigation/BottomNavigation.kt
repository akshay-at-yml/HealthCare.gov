package com.yml.design.components.bottomNavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun HealthCareBottomNavigation(

) {
    val items = remember { createList() }

    BottomNavigation {
        items.forEach {
            BottomNavigationItem(
                icon = {

                },
                label = {
                    Label(it.title)
                },
                selected = false,
                alwaysShowLabel = true, // This hides the title for the unselected items
                onClick = {

                },
            )
        }
    }

}

@Composable
private fun Label(value: String) {
    Text(text = value)
}