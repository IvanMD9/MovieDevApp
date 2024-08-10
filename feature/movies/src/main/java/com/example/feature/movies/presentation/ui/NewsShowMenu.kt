package com.example.feature.movies.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feature.movies.domain.models.CountryNews

@Composable
fun NewsShowMenu(
    expanded: Boolean,
    onClickCountry: (String) -> Unit,
    onCloseMenu: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.padding(
            start = 40.dp,
            top = 40.dp
        ),
        contentAlignment = Alignment.TopStart
    ) {
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                onCloseMenu()
            }
        ) {
            CountryNews.entries.forEach { country ->
                DropdownMenuItem(
                    text = {
                        Text(text = country.country, color = Color.Black)
                    },
                    onClick = {
                        onClickCountry(country.value)
                        onCloseMenu()
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun NewsShowMenuPreview() {
    NewsShowMenu(
        onClickCountry = {},
        onCloseMenu = {},
        expanded = true
    )
}