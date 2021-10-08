package com.victoriagonda.audrey2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.squareup.workflow1.ui.ViewEnvironment
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import com.squareup.workflow1.ui.compose.composeViewFactory
import com.victoriagonda.audrey2.Audrey2Workflow.Rendering

@OptIn(WorkflowUiExperimentalApi::class)
val Audrey2Binding = composeViewFactory { rendering: Rendering, environment: ViewEnvironment ->
  Column(Modifier.fillMaxWidth().padding(16.dp)) {

    Text(
      rendering.message,
      modifier = Modifier
        .align(CenterHorizontally)
        .wrapContentSize()
    )
    Spacer(modifier = Modifier.height(24.dp))
    Button(
      modifier = Modifier.align(CenterHorizontally),
      onClick = rendering.onClick
    ) {
      Text(text = "Feed me.")
    }

    Spacer(modifier = Modifier.height(24.dp))

    LinearProgressIndicator(
      progress = rendering.hunger,
      modifier = Modifier.align(CenterHorizontally),
    )
  }
}

@OptIn(WorkflowUiExperimentalApi::class)
@Preview(heightDp = 150, showBackground = true)
@Composable fun DrawAudry2RenderingPreview() {
  // HelloBinding.Preview(Rendering("Hello!", onClick = {}))
}