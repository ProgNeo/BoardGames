package my.android.boardgames.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import my.android.boardgames.ui.screen.main.MainScreen
import my.android.boardgames.util.NavDestination

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavDestination.MainScreen
    ) {
        composable(
            route = NavDestination.MainScreen
        ) {
            MainScreen(navController)
        }
    }
}
