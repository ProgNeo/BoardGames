package my.android.boardgames.util

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<MutableList<T>>.addNewItem(item: T) {
    val newList = mutableListOf<T>()
    this.value?.let { newList.addAll(it) }
    newList.add(item)
    this.value = newList
}

fun <T> MutableLiveData<MutableList<T>>.removeItem(item: T) {
    val newList = mutableListOf<T>()
    this.value?.let { newList.addAll(it) }
    newList.remove(item)
    this.value = newList
}

fun <T> MutableLiveData<MutableList<T>>.insertItem(index: Int, item: T) {
    val newList = mutableListOf<T>()
    this.value?.let { newList.addAll(it) }
    newList.add(index, item)
    this.value = newList
}
