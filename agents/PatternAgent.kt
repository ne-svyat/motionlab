package agents

import core.Agent
import core.AgentResult
import core.MotionSnapshot

data class PatternResult(

    override val agentName: String = "PatternAgent",

    override val confidence: Float,

    override val timestamp: Long,

    override val summary: String,

    val status: String,

    val activityChangePercent: Float,

    val message: String

) : AgentResult

class PatternAgent : Agent {

    private val averageSteps = 8000

    override fun analyze(
        snapshot: MotionSnapshot
    ): AgentResult {

        val change =
            ((snapshot.steps - averageSteps).toFloat() /
                    averageSteps) * 100f

        return when {

            change > 30f ->
                PatternResult(
                    confidence = 0.95f,
                    timestamp = System.currentTimeMillis(),
                    summary = "Высокая активность",
                    status = "HIGH_ACTIVITY",
                    activityChangePercent = change,
                    message = "Активность значительно выше обычной"
                )

            change < -30f ->
                PatternResult(
                    confidence = 0.95f,
                    timestamp = System.currentTimeMillis(),
                    summary = "Низкая активность",
                    status = "LOW_ACTIVITY",
                    activityChangePercent = change,
                    message = "Активность ниже обычной"
                )

            else ->
                PatternResult(
                    confidence = 0.99f,
                    timestamp = System.currentTimeMillis(),
                    summary = "Нормальная активность",
                    status = "NORMAL",
                    activityChangePercent = change,
                    message = "Активность в пределах нормы"
                )
        }
    }
}
