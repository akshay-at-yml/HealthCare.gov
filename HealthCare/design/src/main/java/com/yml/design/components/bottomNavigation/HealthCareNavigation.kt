package com.yml.design.components.bottomNavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.annotation.ShowkaseComposable

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
private fun Label(value: String) {
    Text(text = value)
}

@ShowkaseComposable(name = "Bottom Tab Label")
@Composable
@Preview
fun LabelPreview() {
    Label(value = "Some Value")
}