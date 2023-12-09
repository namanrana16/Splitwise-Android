package com.example.splitwise.navigation

sealed class Screen(val route:String)
{
    object Splash:Screen(route = "splash_screen")
    object Home:Screen(route = "home_screen")
    object Search:Screen(route = "search_screen")

}
