package com.example.nbctakehome.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nbctakehome.R
import com.example.nbctakehome.data.ShelfItem
import com.example.nbctakehome.ui.theme.NBCTakeHomeTheme

@Composable
fun ShowShelfItem(show: ShelfItem) {
    Column {
        AsyncImage(
            model = show.image,
            contentDescription = show.title,
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(225.dp)
                .aspectRatio(3/4F)
        )
        Text(
            text = show.title,
            color = Color.White,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
fun EpisodeShelfItem(episode: ShelfItem) {
    Column(modifier = Modifier.width(200.dp)) {
        Box(
            modifier = Modifier
                .aspectRatio(16/9F)
        ) {
            AsyncImage(
                model = episode.image,
                contentDescription = episode.title,
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
            )
            if (episode.labelBadge != null) {
                Text(
                    text = episode.labelBadge,
                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier.background(Color.White)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Text(
            text = episode.title,
            color = Color.White,
            modifier = Modifier.padding(top = 8.dp)
        )
        episode.subtitle?.let {
            Text(
                text = it,
                color = Color.White
            )
        }
    }
}

@Composable
fun LiveShelfItem(liveShow: ShelfItem) {
    Column(modifier = Modifier.width(200.dp)) {
        AsyncImage(
            model = liveShow.image,
            contentDescription = liveShow.title,
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            modifier = Modifier.aspectRatio(16/9F)
        )
        Text(
            text = liveShow.title,
            color = Color.White,
            modifier = Modifier.padding(top = 8.dp)
        )
        liveShow.subtitle?.let {
            Text(
                text = it,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ShowShelfItemPreview(
    show: ShelfItem = ShelfItem(
        type = "Show",
        title = "Show Title",
        image = "https://example.com/image.jpg"
    )
) {
    Surface(modifier = Modifier.background(Color.White)) {
        NBCTakeHomeTheme {
            ShowShelfItem(show)
        }
    }
}

@Preview
@Composable
fun EpisodeShelfItemPreview(
    episode: ShelfItem = ShelfItem(
        type = "Episode",
        title = "Episode Title",
        subtitle = "Episode Subtitle",
        image = "https://example.com/image.jpg",
        labelBadge = "Label Badge"
    )
) {
    Surface(modifier = Modifier.background(Color.White)) {
        NBCTakeHomeTheme {
            EpisodeShelfItem(episode)
        }
    }
}

@Preview
@Composable
fun LiveShelfItemPreview(
    liveShow: ShelfItem = ShelfItem(
        type = "Live",
        title = "Live Show Title",
        subtitle = "Live Show Subtitle",
        image = "https://example.com/image.jpg",
        tagline = "Live Show Tagline"
    )
) {
    Surface(modifier = Modifier.background(Color.White)) {
        NBCTakeHomeTheme {
            LiveShelfItem(liveShow)
        }
    }
}