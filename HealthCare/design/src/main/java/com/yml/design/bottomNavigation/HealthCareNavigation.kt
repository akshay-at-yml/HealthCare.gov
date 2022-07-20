package com.yml.design.bottomNavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun <T : BottomNavDestination> HealthCareBottomNavigation(
    isSelected: (T) -> Boolean,
    items: List<T>,
    navigateTo: (T) -> Unit
) {
    BottomNavigation {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    Label(it.title())
                },
                label = {
                },
                selected = isSelected(it),
                alwaysShowLabel = true,
                onClick = {
                    navigateTo(it)
                },
            )
        }
    }
}

@Composable
internal fun Label(value: String) {
    Text(text = value)
}