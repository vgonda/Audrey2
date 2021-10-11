package com.victoriagonda.audrey2

import androidx.compose.material.Text
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import com.squareup.workflow1.ui.compose.composeViewFactory
import com.victoriagonda.audrey2.Audrey2Workflow.Rendering
import com.victoriagonda.audrey2.EndGameWorkflow.EndGameRendering

@OptIn(WorkflowUiExperimentalApi::class) val EndGameBinding =
  composeViewFactory { rendering: EndGameRendering, environment ->
    Text(text = "Game over: ${rendering.message}")
  }