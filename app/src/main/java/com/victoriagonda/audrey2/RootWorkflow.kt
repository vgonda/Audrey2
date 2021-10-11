package com.victoriagonda.audrey2

import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.squareup.workflow1.action
import com.victoriagonda.audrey2.EndGameWorkflow.EndGameProps
import com.victoriagonda.audrey2.EndGameWorkflow.EndGameRendering
import com.victoriagonda.audrey2.RootWorkflow.State
import com.victoriagonda.audrey2.RootWorkflow.State.Audrey2
import com.victoriagonda.audrey2.RootWorkflow.State.GameEnd

object RootWorkflow : StatefulWorkflow<Unit, State, Nothing, Any>() {

  sealed class State {
    object Audrey2 : State()
    object GameEnd : State()
  }

  val endGameAction = action {
    state = GameEnd
  }

  override fun initialState(props: Unit, snapshot: Snapshot?): State {
    return Audrey2
  }

  override fun render(renderProps: Unit, renderState: State, context: RenderContext): Any {
    return when (renderState) {
      is Audrey2 -> context.renderChild(Audrey2Workflow, renderProps) { output ->
        endGameAction
      }
      is GameEnd -> context.renderChild(EndGameWorkflow, EndGameProps("you lost")) { output ->
        action {}
      }
    }
  }

  override fun snapshotState(state: State): Snapshot? {
    return null
  }
}