package com.example.core.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.remember

@Composable
inline fun <T, Param> rememberLambda(
    key1: Param,
    crossinline lambda: @DisallowComposableCalls (Param) -> T,
): () -> T = remember(key1) { { lambda(key1) } }

@Composable
inline fun <T, Param> rememberLambda1(
    crossinline lambda: @DisallowComposableCalls (Param) -> T,
): (Param) -> T = remember { { param -> lambda(param) } }