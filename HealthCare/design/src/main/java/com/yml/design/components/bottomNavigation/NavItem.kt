package com.yml.design.components.bottomNavigation

data class NavItem(val title: String)


fun createList() = listOf(
    NavItem("Dashboard"),
    NavItem("Details"),
    NavItem("Dashboard"),
    NavItem("Dashboard")
)