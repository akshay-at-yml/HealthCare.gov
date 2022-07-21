package com.yml.design.bottomNavigation
//TODO https://www.flaticon.com/uicons
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yml.design.theme.JetBlack
import com.yml.design.theme.Spearmint

@Composable
fun <T : BottomNavDestination> HealthCareBottomNavigation(
    isSelected: (T) -> Boolean,
    items: List<T>,
    navigateTo: (T) -> Unit
) {
    BottomNavigation(
        elevation = 5.dp,
        backgroundColor = Color.White,
        contentColor = Spearmint
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(
                        tint = if (isSelected(it)) Spearmint else JetBlack,
                        painter = painterResource(id = it.icon()),
                        contentDescription = "" //TODO CDS
                    )
                },
                selected = isSelected(it),
                alwaysShowLabel = false,
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