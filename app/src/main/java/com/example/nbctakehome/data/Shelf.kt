package com.example.nbctakehome.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomePage(
    val shelves: List<Shelf>
)

@JsonClass(generateAdapter = true)
data class Shelf(
    val title: String,
    val items: List<ShelfItem>
)

@JsonClass(generateAdapter = true)
data class ShelfItem(
    val type: String,
    val title: String,
    val subtitle: String? = null,
    val image: String,
    val labelBadge: String? = null,
    val tagline: String? = null
)

//sealed class ShelfItem {
//    data class Show(
//        val type: String = "Show",
//        val title: String,
//        val image: String
//    ) : ShelfItem()
//    data class Episode(
//        val type: String = "Episode",
//        val title: String,
//        val subtitle: String,
//        val image: String,
//        val labelBadge: String?
//    ) : ShelfItem()
//    data class Live(
//        val type: String = "Live",
//        val tagline: String,
//        val title: String,
//        val subtitle: String,
//        val image: String
//    ) : ShelfItem()
//}
