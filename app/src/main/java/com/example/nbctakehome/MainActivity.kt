package com.example.nbctakehome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nbctakehome.ui.components.EpisodeShelfItem
import com.example.nbctakehome.ui.components.LiveShelfItem
import com.example.nbctakehome.ui.components.ShowShelfItem
import com.example.nbctakehome.ui.theme.NBCTakeHomeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            NBCTakeHomeTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    HomeScreen(modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.gradient_top),
                        colorResource(id = R.color.gradient_bottom)
                    )
                )
            )
            .verticalScroll(state = rememberScrollState())
    ) {
        viewModel.shelves.forEach { shelf ->
            Text(
                text = shelf.title,
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp, top = 16.dp)
            )
            LazyRow(
                modifier = Modifier.padding(start = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items = shelf.items) { item ->
                    when (item.type) {
                        "Show" -> {
                            ShowShelfItem(item)
                        }
                        "Episode" -> {
                            EpisodeShelfItem(item)
                        }
                        "Live" -> {
                            LiveShelfItem(item)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NBCTakeHomeTheme {
        HomeScreen()
    }
}