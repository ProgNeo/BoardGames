package my.android.boardgames.data.service

import my.android.boardgames.data.model.response.GameListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameService {
    @GET("hotness")
    suspend fun getGameList(
        @Query("geeksite") geekSite: String = "boardgame",
        @Query("nosession") noSession: Boolean = true,
        @Query("objecttype") objectType: String = "thing",
        @Query("showcount") showCount: Int = 30
    ): Response<GameListResponse>
}
