package my.android.boardgames.ui.screen.favourites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import my.android.boardgames.ui.component.GameItem

@Composable
fun FavouriteListScreen(
    viewModel: FavouriteListViewModel = viewModel()
) {
    val gameList by viewModel.gameList.observeAsState(initial = emptyList())
    val isLoading by viewModel.isLoading.observeAsState(initial = true)

    LaunchedEffect(Unit) {
        viewModel.getFavouriteList()
    }

    Surface {
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn {
                items(gameList) { game ->
                    GameItem(game = game, onClick = { viewModel.onGameClick(it) })
                }
            }
        }
    }
}
