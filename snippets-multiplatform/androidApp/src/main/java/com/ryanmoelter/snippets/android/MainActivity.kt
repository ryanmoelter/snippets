package com.ryanmoelter.snippets.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.ryanmoelter.snippets.android.ui.Dimensions
import com.ryanmoelter.snippets.android.ui.LocalDimensions
import com.ryanmoelter.snippets.android.ui.invoke
import com.ryanmoelter.snippets.sampleItems
import com.ryanmoelter.snippets.ui.SharedDimensions

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      MaterialTheme {
        // In a real app, we should provide SharedDimensions via dependency injection
        CompositionLocalProvider(LocalDimensions provides SharedDimensions()) {
          Content()
        }
      }
    }
  }
}

@Composable
fun Content() {
  LazyColumn {
    item {
      Text(
        "Ryan's snippets",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier
          .padding(horizontal = Dimensions.horizontalEdgeSpace())
          .padding(top = Dimensions.verticalEdgeSpace(), bottom = Dimensions.interItemSpace())
      )
    }
    items(sampleItems, { it.primaryText }) { sampleItem ->
      Row(
        Modifier
          .fillMaxWidth()
          .padding(
            horizontal = Dimensions.horizontalEdgeSpace(),
            vertical = Dimensions.halfInterItemSpace()
          ),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(Modifier.weight(1f)) {
          Text(sampleItem.primaryText, fontWeight = FontWeight.Bold)
          Spacer(modifier = Modifier.height(Dimensions.intraItemSpace()))
          Text(sampleItem.secondaryText, style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.width(Dimensions.intraItemSpace()))
        sampleItem.value?.let { Text(it) }
      }
    }
    item {
      Spacer(modifier = Modifier.height(Dimensions.verticalEdgeSpace()))
    }
  }
}

@Preview
@Composable
fun PreviewContent() {
  MaterialTheme {
    CompositionLocalProvider(LocalDimensions provides SharedDimensions()) {
      Content()
    }
  }
}
