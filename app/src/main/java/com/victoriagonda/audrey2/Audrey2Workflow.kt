package com.victoriagonda.audrey2

import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.squareup.workflow1.action
import com.squareup.workflow1.parse
import com.victoriagonda.audrey2.Audrey2Workflow.Rendering
import com.victoriagonda.audrey2.Audrey2Workflow.State

object Audrey2Workflow : StatefulWorkflow<Unit, State, Nothing, Rendering>() {
  data class State(val amountFed: Int) {

    fun increment(): State = State(amountFed + 1)
    fun decrement(): State = State(amountFed - 1)
  }

  data class Rendering(
    val message: String,
    // A percentage representing hunger.
    val hunger: Float,
    val onFeedPlant: () -> Unit,
    val onWithholdPlantFood: () -> Unit,
  )

  private val feedAction = action {
    state = state.increment()
  }

  private val dontFeedAction = action {
    state = state.decrement()
  }

  override fun initialState(
    props: Unit,
    snapshot: Snapshot?
  ): State = snapshot?.bytes?.parse { source -> State(source.readInt()) } ?: State(50)

  override fun render(
    renderProps: Unit,
    renderState: State,
    context: RenderContext
  ): Rendering {
    return Rendering(
      message = "Feed me, Seymour!",
      hunger = (renderState.amountFed/100f).coerceAtMost(1f).coerceAtLeast(0f),
      onFeedPlant = { context.actionSink.send(feedAction) },
      onWithholdPlantFood = { context.actionSink.send(dontFeedAction) }
    )
  }

  override fun snapshotState(state: State): Snapshot = Snapshot.of(state.amountFed)
}