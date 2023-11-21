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
import com.faroukabichou.kotlincleanarch.details.presentation.DetailsScreen
import com.faroukabichou.kotlincleanarch.details.presentation.DetailsViewModel
import com.faroukabichou.kotlincleanarch.home.presentation.HomeScreen
import com.faroukabichou.kotlincleanarch.home.presentation.HomeViewModel

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(
            route = Routes.Home.route
        ) {
            val viewModel = viewModel<HomeViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            HomeScreen(
                state = state,
                onEvent = viewModel::onEvent,
                navigateToRecommended = { catId ->
                    navController.navigate(
                        route = Routes.Details.route + "/${catId}"
                    )
                },
            )
        }

        composable(
            route = "${Routes.Details.route}/{catId}",
            arguments = listOf(
                navArgument("catId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val catId = backStackEntry.arguments?.getString("catId") ?: ""
            val viewModel = viewModel<DetailsViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            DetailsScreen(
                state = state,
                onEvent = viewModel::onEvent,
                selectedAudioId = catId,
            )
        }
    }
}