package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = NewaRedLight,
    onPrimary = Color.White,
    primaryContainer = NewaRedDark,
    onPrimaryContainer = NewaRedContainer,
    secondary = NewaGold,
    onSecondary = Color.Black,
    secondaryContainer = NewaOnGoldContainer,
    onSecondaryContainer = NewaGoldLight,
    tertiary = NewaTerracotta,
    background = HakuBlack,
    onBackground = NewaCream,
    surface = HakuSurface,
    onSurface = NewaCream,
    surfaceVariant = HakuCard,
    onSurfaceVariant = NewaSurfaceVariant,
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005)
)

private val LightColorScheme = lightColorScheme(
    primary = NewaRed,
    onPrimary = Color.White,
    primaryContainer = NewaRedContainer,
    onPrimaryContainer = NewaOnRedContainer,
    secondary = NewaGold,
    onSecondary = Color.Black,
    secondaryContainer = NewaGoldContainer,
    onSecondaryContainer = NewaOnGoldContainer,
    tertiary = NewaTerracotta,
    onTertiary = Color.White,
    background = NewaCream,
    onBackground = HakuBlack,
    surface = Color.White,
    onSurface = HakuBlack,
    surfaceVariant = NewaSurfaceVariant,
    onSurfaceVariant = NewaOnSurfaceVariant,
    error = NewaError,
    onError = Color.White
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Keep authentic cultural colors by default
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
