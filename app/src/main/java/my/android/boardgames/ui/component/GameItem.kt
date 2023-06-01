package my.android.boardgames.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import my.android.boardgames.R
import my.android.boardgames.data.model.Game

@Composable
fun GameItem(
    game: Game,
    modifier: Modifier = Modifier,
    onClick: (Game) -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(5.dp)
            .clickable { onClick(game) }
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(game.imageUrl),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp)
            )
            Column(Modifier.padding(15.dp)) {
                Text(
                    text = game.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(bottom = 3.dp),
                    text = game.description,
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.release_year, game.yearPublished),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = stringResource(id = R.string.star_icon),
                        tint = if (game.isFavourite) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            Color.Transparent
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBookItem() {
    GameItem(
        game = Game(
            id = 1,
            name = "Ticket to Ride Legacy: Legends of the West",
            imageUrl = "",
            description = "Build train lines across the United States in a twelve-game campaign.",
            yearPublished = "2023",
            isFavourite = true
        )
    )
}
