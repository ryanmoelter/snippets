package com.ryanmoelter.snippets.ui

import me.tatarka.inject.annotations.Inject

@Inject
class SharedDimensions {
  val horizontalEdgeSpace: SharedDp = 24.dp
  val verticalEdgeSpace: SharedDp = 48.dp
  val interItemSpace: SharedDp = 24.dp
  val halfInterItemSpace: SharedDp = 12.dp
  val intraItemSpace: SharedDp = 8.dp
  val minimumTouchTargetSize: SharedDp = 48.dp
  val dividerThickness: SharedDp = 1.dp
  val cornerRadius: SharedDp = 16.dp
}
