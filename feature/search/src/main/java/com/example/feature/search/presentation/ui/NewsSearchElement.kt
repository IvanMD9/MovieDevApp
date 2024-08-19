package com.example.feature.search.presentation.ui

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
import com.example.feature.search.R
import com.example.feature.search.domain.models.NewsSearchItem

@Composable
fun NewsSearchElement(
    searchItem: NewsSearchItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(12.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (searchItem.image != null) {
            AsyncImage(
                modifier = Modifier
                    .height(140.dp)
                    .clip(RoundedCornerShape(12.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(searchItem.image)
                    .crossfade(true)
                    .size(Size.ORIGINAL)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
        if (searchItem.author != null) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = searchItem.author,
                fontSize = 16.sp,
                color = colorResource(id = R.color.colorContentSecondary),
                fontWeight = FontWeight.ExtraBold,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(4.dp))
        }

        if (searchItem.title != null) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = searchItem.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorContentPrimary),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
        }

        if (searchItem.content != null) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = searchItem.content,
                fontSize = 10.sp,
                color = colorResource(id = R.color.colorContentSecondary),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
private fun NewsElementPreview() {
    NewsSearchElement(
        searchItem = NewsSearchItem(
            author = "Yahoo Sports",
            title = "Paris Olympics gymnastics live updates: Suni Lee earns bronze on bars as apparatus finals continue - Yahoo Sports",
            image = "",
            content = "People living with chronic pain are more likely than their peers without pain to need mental health treatment"
        ),
    )
}