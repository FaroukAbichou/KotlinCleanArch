package com.faroukabichou.kotlincleanarch.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.faroukabichou.kotlincleanarch.home.presentation.HomeScreen
import com.faroukabichou.kotlincleanarch.home.presentation.HomeViewModel
import com.faroukabichou.kotlincleanarch.details.presentation.DetailsScreen
import com.faroukabichou.kotlincleanarch.details.presentation.DetailsViewModel

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Music.route
    ) {
        composable(
            route = Routes.Home.route
        ) {
            val viewModel = viewModel<HomeViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            HomeScreen(
                state = state,
                onEvent = viewModel::onEvent,
                navigateToRecommended = {musicId ->
                    navController.navigate(
                        route = Routes.Recommended.route  + "/${musicId}"
                    )
                },
                navigateToPlayList = { musicId ->
                    navController.navigate(
                        route = Routes.Music.route + "/${musicId}"
                    )
                },
            )
        }
        composable(
            route = "${Routes.Recommended.route}/{musicId}",
            arguments = listOf(
                navArgument("musicId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val musicId = backStackEntry.arguments?.getString("musicId") ?: ""
            val viewModel = viewModel<DetailsViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            DetailsScreen(
                state = state,
                onEvent = viewModel::onEvent,
                selectedAudioId = musicId,
                navigateBack = {
                    navController.popBackStack()
                },
            )
        }
    }
}