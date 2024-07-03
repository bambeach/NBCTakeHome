package com.example.nbctakehome

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.nbctakehome.data.HomePage
import com.example.nbctakehome.data.Shelf
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val application: Application
) : ViewModel() {

    val moshi = Moshi.Builder().build()
    @OptIn(ExperimentalStdlibApi::class)
    private val adapter: JsonAdapter<HomePage> = moshi.adapter<HomePage>()
    val shelves = loadShelves()

    private fun loadShelves() : List<Shelf> {
        val shelvesJson = application.assets.open("homepage.json").bufferedReader().use { it.readText() }
        val homePage = adapter.fromJson(shelvesJson)
        return homePage?.shelves ?: emptyList()
    }
}