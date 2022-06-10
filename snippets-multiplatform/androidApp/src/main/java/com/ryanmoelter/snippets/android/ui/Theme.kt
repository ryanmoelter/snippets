package com.ryanmoelter.snippets.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import com.ryanmoelter.snippets.ui.SharedDimensions

val LocalDimensions = compositionLocalOf<SharedDimensions> {
  // Expect that SharedDimensions is provided, like what MaterialTheme does
  error("Shared dimensions haven't been provided.")
}

// Easy accessor for our SharedDimensions object
val Dimensions
  @Composable
  get() = LocalDimensions.current
