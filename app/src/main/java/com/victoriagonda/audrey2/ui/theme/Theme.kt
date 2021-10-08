package com.victoriagonda.audrey2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
  primary = primaryColor,
  primaryVariant = primaryLightColor,
  secondary = secondaryColor,
  secondaryVariant = secondaryLightColor,
)

private val LightColorPalette = lightColors(
  primary = primaryColor,
  primaryVariant = primaryDarkColor,
  secondary = secondaryColor,
  secondaryVariant = secondaryDarkColor,

  /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun Audrey2Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  }

  MaterialTheme(
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
  )
}