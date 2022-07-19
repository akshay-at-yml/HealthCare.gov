package com.yml.design.components.bottomNavigation

interface BottomNavDestination {
    fun title(): String = ""
    fun icon(): Int = -1
}