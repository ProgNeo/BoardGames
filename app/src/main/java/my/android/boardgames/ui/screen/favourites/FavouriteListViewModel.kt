package my.android.boardgames.ui.screen.favourites

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import my.android.boardgames.App
import my.android.boardgames.data.db.AppDatabase
import my.android.boardgames.data.model.Game
import my.android.boardgames.data.service.GameService
import my.android.boardgames.util.removeItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FavouriteListViewModel : ViewModel() {

    private val _gameList = MutableLiveData<MutableList<Game>>()
    val gameList: LiveData<MutableList<Game>> = _gameList

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.geekdo.com/api/")
        .build()
        .create(GameService::class.java)

    suspend fun getFavouriteList() = coroutineScope {
        withContext(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                val db = AppDatabase.getInstance(App.appContext)
                val list = db.gamesDao().getFavouriteList()

                _gameList.postValue(list.toMutableList())
            } catch (e: Exception) {
                Log.e(this.javaClass.simpleName, e.message.toString())
            } finally {
                _gameList.value?.sortBy { it.id }
                _isLoading.postValue(false)
            }
        }
    }

    fun onGameClick(game: Game) {
        val db = AppDatabase.getInstance(App.appContext)
        if (db.gamesDao().isExists(game.id)) {
            db.gamesDao().delete(game)
            _gameList.removeItem(game)
        }
    }
}
