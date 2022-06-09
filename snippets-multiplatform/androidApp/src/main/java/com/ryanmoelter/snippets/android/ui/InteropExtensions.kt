package com.ryanmoelter.snippets.android.ui

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ryanmoelter.snippets.ui.SharedDp

operator fun SharedDp.invoke(): Dp = value.dp
fun SharedDp.toDp(): Dp = this()
fun Dp.toSharedDp(): SharedDp = SharedDp(value.toDouble())
