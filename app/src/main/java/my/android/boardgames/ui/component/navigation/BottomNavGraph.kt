package my.android.boardgames.ui.component.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import my.android.boardgames.ui.screen.favourites.FavouriteListScreen
import my.android.boardgames.ui.screen.gamelist.GameListScreen
import my.android.boardgames.util.animatedComposable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavGraph(
    navController: NavHostController,
    bottomNavController: NavHostController
) {
    AnimatedNavHost(
        navController = bottomNavController,
        startDestination = BottomNavItem.GameListScreen.route
    ) {
        animatedComposable(
            route = BottomNavItem.GameListScreen.route
        ) {
            GameListScreen()
        }
        animatedComposable(
            route = BottomNavItem.FavouritesScreen.route
        ) {
            FavouriteListScreen()
        }
    }
}
