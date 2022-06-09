package com.ryanmoelter.snippets.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import com.ryanmoelter.snippets.ui.SharedDimensions

val LocalDimensions = compositionLocalOf {
  // In a real app, we should provide this via dependency injection, throwing an error here
  // and using CompositionLocalOf near the root composable
  SharedDimensions()
}
val Dimensions
  @Composable
  get() = LocalDimensions.current
