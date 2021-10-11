package com.victoriagonda.audrey2

import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.victoriagonda.audrey2.EndGameWorkflow.EndGameProps
import com.victoriagonda.audrey2.EndGameWorkflow.EndGameRendering
import com.victoriagonda.audrey2.EndGameWorkflow.EndGameState

object EndGameWorkflow : StatefulWorkflow<EndGameProps, EndGameState, Nothing, EndGameRendering>() {

  data class EndGameProps(val message: String)

  data class EndGameState(val message: String)

  data class EndGameRendering(val message: String)

  override fun initialState(props: EndGameProps, snapshot: Snapshot?): EndGameState {
    return EndGameState(props.message)
  }

  override fun render(
    renderProps: EndGameProps,
    renderState: EndGameState,
    context: RenderContext
  ): EndGameRendering {
    return EndGameRendering(
      renderState.message
    )
  }

  override fun snapshotState(state: EndGameState): Snapshot? {
    return null
  }
}