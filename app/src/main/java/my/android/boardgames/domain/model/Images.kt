package my.android.boardgames.domain.model

import com.google.gson.annotations.SerializedName

data class Images(
    val square30: Image,
    val square100: Image,
    @SerializedName("mediacard")
    val mediaCard: Image
)
