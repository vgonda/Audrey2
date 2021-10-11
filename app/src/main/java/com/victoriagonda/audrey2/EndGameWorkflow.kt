package com.victoriagonda.audrey2

import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.victoriagonda.audrey2.Audrey2Workflow.Rendering
import com.victoriagonda.audrey2.Audrey2Workflow.State

object EndGameWorkflow: StatefulWorkflow<Unit, State, Nothing, Rendering>() {
  override fun initialState(props: Unit, snapshot: Snapshot?): State {
    return State(50)
  }

  override fun render(renderProps: Unit, renderState: State, context: RenderContext): Rendering {
    return Rendering("message", 0f, {}, {})
  }

  override fun snapshotState(state: State): Snapshot? {
    return null
  }
}