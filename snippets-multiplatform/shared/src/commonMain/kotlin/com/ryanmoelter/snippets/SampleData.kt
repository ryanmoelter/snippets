package com.ryanmoelter.snippets

data class SampleItem(val primaryText: String, val secondaryText: String, val value: String? = null)

val sampleItems = listOf(
  SampleItem("First item", "I'm the first item", "$20"),
  SampleItem("Second item", "I'm some details", "$50"),
  SampleItem("Third item", "I'm the middle item", "$20"),
  SampleItem("Fourth item", "I'm unimportant", "$30"),
  SampleItem("Fifth item", "Saved the best for last, huh?", "$100"),
)
