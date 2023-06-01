package my.android.boardgames

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        lateinit var appContext: Context
        fun setContext(context: Context) {
            appContext = context
        }
    }
}
