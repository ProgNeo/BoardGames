package my.android.boardgames.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import my.android.boardgames.domain.model.Thing

@Entity(tableName = "games")
data class Game(
    @PrimaryKey
    @SerializedName("objectid")
    var id: Int,
    var name: String,
    @SerializedName("imageurl")
    var imageUrl: String,
    var description: String,
    @SerializedName("yearpublished")
    var yearPublished: String,
    var isFavourite: Boolean
) {
    constructor(thing: Thing, isFavourite: Boolean = false) : this(
        id = thing.id,
        name = thing.name,
        imageUrl = thing.images.mediaCard.src,
        description = thing.description,
        yearPublished = thing.yearPublished,
        isFavourite = isFavourite
    )
}
