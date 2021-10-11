package com.victoriagonda.audrey2

import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.squareup.workflow1.action

object RootWorkflow : StatefulWorkflow<Unit, Unit, Nothing, Any>() {

  private val dumbyAction = action { }

  override fun initialState(props: Unit, snapshot: Snapshot?) {
    return Unit
  }

  override fun render(renderProps: Unit, renderState: Unit, context: RenderContext): Any {
    val twoeyScreen = context.renderChild(Audrey2Workflow, renderProps) { output ->
      dumbyAction
    }
    return twoeyScreen
  }

  override fun snapshotState(state: Unit): Snapshot? {
    return null
  }
}