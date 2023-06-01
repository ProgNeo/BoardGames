package my.android.boardgames.ui.screen.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import my.android.boardgames.ui.component.navigation.BottomNavBar
import my.android.boardgames.ui.component.navigation.BottomNavGraph

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    navController: NavHostController
) {
    val bottomNavController = rememberAnimatedNavController()

    Scaffold(
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                BottomNavGraph(
                    navController = navController,
                    bottomNavController = bottomNavController
                )
            }
        },
        bottomBar = {
            BottomNavBar(navController = bottomNavController)
        }
    )
}
