package my.android.boardgames.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import my.android.boardgames.data.model.Game

@Dao
interface GamesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(game: Game): Long

    @Query("SELECT * FROM games")
    fun getFavouriteList(): List<Game>

    @Query("SELECT EXISTS(SELECT * FROM games WHERE id == :id)")
    fun isExists(id: Int): Boolean

    @Delete
    fun delete(game: Game)
}
