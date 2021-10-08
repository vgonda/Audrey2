package com.victoriagonda.audrey2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
  primary = primaryColor,
  primaryVariant = primaryLightColor,
  secondary = secondaryColor,
  secondaryVariant = secondaryLightColor,
  onPrimary = Color.Black,
  onSecondary = Color.White
)

private val LightColorPalette = lightColors(
  primary = primaryColor,
  primaryVariant = primaryDarkColor,
  secondary = secondaryColor,
  secondaryVariant = secondaryDarkColor,
  onPrimary = Color.Black,
  onSecondary = Color.White

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