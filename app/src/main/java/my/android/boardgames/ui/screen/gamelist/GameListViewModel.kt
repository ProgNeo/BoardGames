package my.android.boardgames.ui.screen.gamelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.android.boardgames.App
import my.android.boardgames.data.db.AppDatabase
import my.android.boardgames.data.model.Game
import my.android.boardgames.data.service.GameService
import my.android.boardgames.util.addNewItem
import my.android.boardgames.util.insertItem
import my.android.boardgames.util.removeItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameListViewModel : ViewModel() {

    private val _gameList = MutableLiveData<MutableList<Game>>()
    val gameList: LiveData<MutableList<Game>> = _gameList

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.geekdo.com/api/")
        .build()
        .create(GameService::class.java)

    suspend fun getGameList() = viewModelScope.launch {
        _isLoading.postValue(true)
        try {
            val db = AppDatabase.getInstance(App.appContext)
            val response = _retrofit.getGameList().body()
            response?.items?.forEach { game ->
                _gameList.addNewItem(Game(game, db.gamesDao().isExists(game.id)))
            }
        } catch (e: Exception) {
            Log.e(this.javaClass.simpleName, e.message.toString())
        } finally {
            _gameList.value?.sortBy { it.id }
            _isLoading.postValue(false)
        }
    }

    fun onGameClick(index: Int, game: Game) {
        val db = AppDatabase.getInstance(App.appContext)
        game.isFavourite = !game.isFavourite
        if (db.gamesDao().isExists(game.id)) {
            db.gamesDao().delete(game)
        } else {
            db.gamesDao().insert(game)
        }

        _gameList.removeItem(game)
        _gameList.insertItem(index, game)
    }
}
