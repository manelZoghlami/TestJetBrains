package com.example.testjetbrains.ui.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domainlayer.useCase.GetListBrainsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(private val getListBrainsUseCase: GetListBrainsUseCase) {
    private val listState = MutableLiveData<List<JetBrainsUi>>()
    val state: LiveData<List<JetBrainsUi>> = listState
    fun getAllList() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val list = getListBrainsUseCase.invoke()
                withContext(Dispatchers.Main) {
                    listState.value = list.map {
                        it.toUi()
                    }
                }
            }  catch (e: Exception) {
                println("Handle Exception $e")
            }
        }
    }
}