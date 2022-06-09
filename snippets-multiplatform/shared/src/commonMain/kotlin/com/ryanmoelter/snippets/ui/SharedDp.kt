package com.ryanmoelter.snippets.ui

data class SharedDp(val value: Double) {
  operator fun times(other: Double) = SharedDp(value * other)
  operator fun times(other: Float) = this * other.toDouble()
  operator fun times(other: Int) = this * other.toDouble()

  operator fun div(other: Double) = SharedDp(value / other)
  operator fun div(other: Float) = this / other.toDouble()
  operator fun div(other: Int) = this / other.toDouble()

  operator fun minus(other: SharedDp) = SharedDp(value - other.value)
  operator fun plus(other: SharedDp) = SharedDp(value + other.value)
}

internal val Int.dp
  get() = SharedDp(this.toDouble())
internal val Double.dp
  get() = SharedDp(this)
internal val Float.dp
  get() = SharedDp(this.toDouble())
