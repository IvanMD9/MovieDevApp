package com.example.feature.movies.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.feature.movies.domain.models.MovieItem

@Composable
fun MovieElement(
    movieItem: MovieItem,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = "https://image.tmdb.org/t/p/original${movieItem.posterPath}",
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview
@Composable
private fun MovieElementPreview() {
    MovieElement(
        movieItem = MovieItem(
            id = 0,
            originalTitle = "Marvel",
            overview = "description",
            posterPath = "",
            releaseDate = "2024-06-11",
            voteAverage = 7.8,
            voteCount = 1459,
        )
    )
}