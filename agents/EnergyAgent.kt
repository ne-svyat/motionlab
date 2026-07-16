package agents

import core.Agent
import core.AgentResult
import core.MotionSnapshot
import core.UserProfile

data class EnergyResult(

    override val agentName: String = "EnergyAgent",

    override val confidence: Float,

    override val timestamp: Long,

    override val summary: String,

    val basalCalories: Float,

    val activeCalories: Float,

    val totalCalories: Float,

    val level: String

) : AgentResult

class EnergyAgent(
    private val user: UserProfile
) : Agent {

    override fun analyze(
        snapshot: MotionSnapshot
    ): AgentResult {

        val basal = user.basalCaloriesPerDay()

        val active =
            user.weightKg *
            snapshot.distanceMeters / 1000f *
            0.9f

        val total = basal + active

        val level =
            when {

                active < 200f -> "LOW"

                active < 600f -> "MEDIUM"

                else -> "HIGH"
            }

        return EnergyResult(
            confidence = 0.98f,
            timestamp = System.currentTimeMillis(),
            summary = "Активный расход ${active.toInt()} ккал",
            basalCalories = basal,
            activeCalories = active,
            totalCalories = total,
            level = level
        )
    }
}
