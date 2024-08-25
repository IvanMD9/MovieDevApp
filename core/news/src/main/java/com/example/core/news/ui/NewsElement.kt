package com.example.core.news.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import com.example.core.news.model.NewsItem
import com.example.core.ui.NewsDimensions
import com.example.core.ui.R as coreUiR

@Composable
fun NewsElement(
    newsItem: NewsItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(NewsDimensions.Spacing.space_12))
            .padding(NewsDimensions.Spacing.space_8),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (newsItem.image != null) {
            AsyncImage(
                modifier = Modifier
                    .height(140.dp)
                    .clip(RoundedCornerShape(NewsDimensions.Spacing.space_12)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(newsItem.image)
                    .crossfade(true)
                    .size(Size.ORIGINAL)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(NewsDimensions.Spacing.space_4))
        }
        if (newsItem.author != null) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = newsItem.author,
                fontSize = 16.sp,
                color = colorResource(id = coreUiR.color.colorContentSecondary),
                fontWeight = FontWeight.ExtraBold,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(NewsDimensions.Spacing.space_4))
        }

        if (newsItem.title != null) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = newsItem.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = coreUiR.color.colorContentPrimary),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(NewsDimensions.Spacing.space_4))
        }

        if (newsItem.content != null) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = newsItem.content,
                fontSize = 10.sp,
                color = colorResource(id = coreUiR.color.colorContentSecondary),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(NewsDimensions.Spacing.space_8))
        }
    }
}

@Preview
@Composable
private fun NewsElementPreview() {
    NewsElement(
        newsItem = NewsItem(
            author = "Yahoo Sports",
            title = "Paris Olympics gymnastics live updates: Suni Lee earns bronze on bars as apparatus finals continue - Yahoo Sports",
            image = "",
            content = "People living with chronic pain are more likely than their peers without pain to need mental health treatment"
        ),
    )
}