package com.example.feature.search.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchToolbar(
    value: String,
    onValueChange: (String) -> Unit,
    onBackClick: () -> Unit,
    onClearText: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .padding(end = 8.dp)
                .clickable(onClick = onBackClick),
            tint = Color.Black
        )
        SearchTextField(
            modifier = Modifier.weight(1f),
            value = value,
            onValueChange = { newTextState ->
                if (value != newTextState) {
                    onValueChange(newTextState)
                }
            },
            onClearText = onClearText,
        )
    }
}

@Preview
@Composable
private fun SearchToolbarPreview() {
    SearchToolbar(
        value = "Movie",
        onValueChange = {},
        onBackClick = {},
        onClearText = {}
    )
}