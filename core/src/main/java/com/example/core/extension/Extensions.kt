package com.example.core.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.remember

@Composable
inline fun <T> rememberLambda(
    crossinline lambda: @DisallowComposableCalls () -> T,
): () -> T = remember { { lambda() } }

@Composable
inline fun <T, Param> rememberLambda1(
    crossinline lambda: @DisallowComposableCalls (Param) -> T,
): (Param) -> T = remember { { param -> lambda(param) } }