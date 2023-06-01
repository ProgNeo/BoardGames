package my.android.boardgames.domain.model

import com.google.gson.annotations.SerializedName

data class Thing(
    @SerializedName("objectid")
    val id: Int,
    val name: String,
    val images: Images,
    val description: String,
    @SerializedName("yearpublished")
    val yearPublished: String
)
