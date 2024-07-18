package com.example.feature.movies.presentation.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ProgressAverage(
    progress: Double,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.DarkGray,
    strokeWidth: Float = 8f
) {
    val clampedProgress = progress.coerceIn(1.0, 10.0)
    val normalizedProgress = (clampedProgress - 1.0) / 9.0

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val radius = size.minDimension / 2
            val center = Offset(x = size.width / 2, y = size.height / 2)

            drawCircle(
                color = backgroundColor,
                radius = radius,
                center = center,
                style = Stroke(width = strokeWidth)
            )

            drawArc(
                color = getColorRange(progress),
                startAngle = -90f,
                sweepAngle = 360 * normalizedProgress.toFloat(),
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2)
            )
        }
        Text(
            text = String.format("%.1f", progress),
            color = Color.Black,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

fun getColorRange(progress: Double): Color {
    return when (progress) {
        in 0.0..4.5 -> Color.Red
        in 4.5..7.0 -> Color.Yellow
        in 7.0..10.0 -> Color.Green
        else -> Color.Transparent
    }
}