package my.android.boardgames.ui.component.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavBar(navController: NavHostController) {
    val bottomNavItems = listOf(
        BottomNavItem.GameListScreen,
        BottomNavItem.FavouritesScreen
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar(
        modifier = Modifier.navigationBarsPadding()
    ) {
        bottomNavItems.forEach { item ->
            AddItem(
                bottomNavItem = item,
                navBackStackEntry = navBackStackEntry,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    bottomNavItem: BottomNavItem,
    navBackStackEntry: NavBackStackEntry?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = stringResource(id = bottomNavItem.titleResId))
        },
        icon = {
            Icon(
                imageVector = bottomNavItem.icon,
                contentDescription = "${bottomNavItem.titleResId} Icon"
            )
        },
        selected = bottomNavItem.route == navBackStackEntry?.destination?.route,
        alwaysShowLabel = true,
        onClick = { navController.navigate(bottomNavItem.route) }
    )
}

@Composable
@Preview(showBackground = false)
fun BottomNavBarPreview() {
    val navController = rememberNavController()
    BottomNavBar(navController = navController)
}
