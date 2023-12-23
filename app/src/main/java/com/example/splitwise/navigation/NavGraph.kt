package com.example.splitwise.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.splitwise.presentation.screens.home.HomeScreen
import com.example.splitwise.presentation.screens.search.SearchScreen
import com.example.splitwise.presentation.screens.splash.SplashScreen

@ExperimentalCoilApi
@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(navController: NavHostController){

    NavHost(navController = navController,
        startDestination =Screen.Splash.route
    ){
        composable(route = Screen.Splash.route){
            SplashScreen(navController = navController)
        }



        composable(route = Screen.Home.route){

            HomeScreen(navController = navController)
        }


        composable(route = Screen.Search.route){

            SearchScreen(navController = navController)
        }





    }

}