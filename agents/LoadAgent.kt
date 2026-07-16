package agents

import core.Agent
import core.AgentResult
import core.MotionSnapshot
import core.CarryingProfile

data class LoadResult(

    override val agentName: String = "LoadAgent",

    override val confidence: Float,

    override val timestamp: Long,

    override val summary: String,

    val extraWeightKg: Float,

    val loadLevel: String,

    val impactPercent: Float

) : AgentResult


class LoadAgent(
    private val carrying: CarryingProfile
) : Agent {

    override fun analyze(
        snapshot: MotionSnapshot
    ): AgentResult {

        val weight =
            carrying.backpackKg


        val level =
            when {

                weight < 3f ->
                    "LOW"

                weight < 8f ->
                    "MEDIUM"

                else ->
                    "HIGH"
            }


        val impact =
            weight * 1.5f


        return LoadResult(
            confidence = 0.90f,
            timestamp = System.currentTimeMillis(),
            summary = "Дополнительная нагрузка ${weight} кг",
            extraWeightKg = weight,
            loadLevel = level,
            impactPercent = impact
        )
    }
}
