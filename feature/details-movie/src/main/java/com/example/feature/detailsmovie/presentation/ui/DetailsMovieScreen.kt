package com.example.feature.detailsmovie.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import com.example.feature.detailsmovie.presentation.store.DetailMovieAction
import com.example.feature.detailsmovie.presentation.store.DetailMovieStore

@Composable
fun DetailMovieScreen(
    detailMovieStore: DetailMovieStore,
    onBackClick: () -> Unit,
    movieUuid: Int,
    modifier: Modifier = Modifier,
) {
    val store by remember(detailMovieStore) {
        detailMovieStore.state
    }.collectAsState()

    val stateDetailMovie = store.detailMovie

    LaunchedEffect(Unit) {
        detailMovieStore.consume(
            DetailMovieAction.LoadDetail(movieUuid)
        )
    }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .background(Color.Gray)
                    .padding(horizontal = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(24.dp)
                        .padding(end = 8.dp)
                        .clickable(onClick = onBackClick),
                    tint = Color.Black
                )
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = store.detailMovie.originalTitle,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        },
        content = { _ ->
            if (store.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                Column(
                    modifier = modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .height(250.dp)
                            .fillMaxWidth(),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://image.tmdb.org/t/p/original${stateDetailMovie.posterPath}")
                            .crossfade(true)
                            .size(Size.ORIGINAL)
                            .diskCachePolicy(CachePolicy.ENABLED)
                            .memoryCachePolicy(CachePolicy.ENABLED)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = stateDetailMovie.originalTitle,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = stateDetailMovie.overview,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                }
            }
        }
    )
}