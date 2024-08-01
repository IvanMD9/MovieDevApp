package com.example.feature.search.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import com.example.feature.search.domain.models.MovieItem

@Composable
fun MovieSearchElement(
    movieItem: MovieItem,
    onClickItem: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val progress by remember { mutableDoubleStateOf(movieItem.voteAverage) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClickItem)
    ) {
        AsyncImage(
            modifier = Modifier
                .height(140.dp)
                .clip(RoundedCornerShape(12.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://image.tmdb.org/t/p/original${movieItem.posterPath}")
                .crossfade(true)
                .size(Size.ORIGINAL)
                .diskCachePolicy(CachePolicy.ENABLED)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = movieItem.originalTitle,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                color = Color.Black,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(8.dp))
            ProgressAverage(
                progress = progress,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}


@Preview
@Composable
private fun MovieSearchElementPreview() {
    MovieSearchElement(
        movieItem = MovieItem(
            id = 0,
            originalTitle = "Marvel",
            overview = "description",
            posterPath = "",
            releaseDate = "2024-06-11",
            voteAverage = 7.8,
            voteCount = 1459,
        ),
        onClickItem = {}
    )
}