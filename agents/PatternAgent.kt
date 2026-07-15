package agents

import core.MotionSnapshot

data class PatternResult(
    val status: String,
    val activityChangePercent: Float,
    val message: String
)

class PatternAgent {

    fun analyze(
        current: MotionSnapshot,
        averageSteps: Int
    ): PatternResult {

        val change =
            ((current.steps - averageSteps).toFloat()
                    / averageSteps) * 100f


        return when {

            change > 30 ->
                PatternResult(
                    status = "HIGH_ACTIVITY",
                    activityChangePercent = change,
                    message = "Активность значительно выше обычной"
                )

            change < -30 ->
                PatternResult(
                    status = "LOW_ACTIVITY",
                    activityChangePercent = change,
                    message = "Активность ниже обычной"
                )

            else ->
                PatternResult(
                    status = "NORMAL",
                    activityChangePercent = change,
                    message = "Активность в пределах нормы"
                )
        }
    }
}
