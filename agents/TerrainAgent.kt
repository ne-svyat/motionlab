package agents

import core.Agent
import core.AgentResult
import core.MotionSnapshot

data class TerrainResult(

    override val agentName: String = "TerrainAgent",

    override val confidence: Float,

    override val timestamp: Long,

    override val summary: String,

    val terrain: String,

    val difficulty: Int,

    val description: String

) : AgentResult


class TerrainAgent : Agent {

    override fun analyze(
        snapshot: MotionSnapshot
    ): AgentResult {

        val terrain =
            when {

                snapshot.intensity > 0.8f ->
                    "HARD_ACTIVITY"

                snapshot.speedKmh > 6f ->
                    "FAST_WALK"

                else ->
                    "NORMAL_WALK"
            }


        val difficulty =
            when (terrain) {

                "HARD_ACTIVITY" -> 8

                "FAST_WALK" -> 5

                else -> 3
            }


        val description =
            when (terrain) {

                "HARD_ACTIVITY" ->
                    "Высокая нагрузка движения"

                "FAST_WALK" ->
                    "Быстрое движение"

                else ->
                    "Обычное движение"
            }


        return TerrainResult(
            confidence = 0.85f,
            timestamp = System.currentTimeMillis(),
            summary = description,
            terrain = terrain,
            difficulty = difficulty,
            description = description
        )
    }
}
