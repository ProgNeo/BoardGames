package my.android.boardgames.ui.component.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import my.android.boardgames.R

sealed class BottomNavItem(
    val route: String,
    val titleResId: Int,
    val icon: ImageVector
) {
    object GameListScreen : BottomNavItem(
        route = "movie_list",
        titleResId = R.string.game_list,
        icon = Icons.Filled.Home
    )

    object FavouritesScreen : BottomNavItem(
        route = "favourites",
        titleResId = R.string.favourites,
        icon = Icons.Filled.Favorite
    )
}
