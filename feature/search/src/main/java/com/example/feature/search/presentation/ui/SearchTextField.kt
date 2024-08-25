package com.example.feature.search.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.ui.NewsDimensions
import com.example.feature.search.R
import com.example.core.ui.R as coreUiR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onClearText: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        modifier = modifier
            .height(40.dp)
            .clip(RoundedCornerShape(NewsDimensions.Spacing.space_12))
            .background(
                color = colorResource(id = coreUiR.color.colorBgSecondary)
            ),
        value = value,
        enabled = true,
        onValueChange = onValueChange,
        decorationBox = { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                placeholder = {
                    Text(
                        modifier = Modifier.padding(start = NewsDimensions.Spacing.space_8),
                        text = stringResource(id = R.string.app_search_text_field_placeholder),
                        fontSize = 10.sp,
                        color = colorResource(id = coreUiR.color.colorContentPrimary)
                    )
                },
                trailingIcon = {
                    if (value.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .clickable(onClick = onClearText),
                            tint = colorResource(id = coreUiR.color.colorContentPrimary)
                        )
                    }
                },
                container = {},
                contentPadding = PaddingValues(horizontal = NewsDimensions.Spacing.space_16),
            )
        },
        cursorBrush = SolidColor(
            value = colorResource(id = coreUiR.color.colorContentPrimary)
        ),
        textStyle = TextStyle
            .Default
            .copy(color = colorResource(id = coreUiR.color.colorContentPrimary)),
        singleLine = true
    )
}