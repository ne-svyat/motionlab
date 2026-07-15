package core

import agents.PatternAgent
import agents.PatternResult

class MotionEngine {

    private val patternAgent = PatternAgent()

    fun analyze(
        snapshot: MotionSnapshot,
        averageSteps: Int
    ): PatternResult {

        return patternAgent.analyze(
            current = snapshot,
            averageSteps = averageSteps
        )
    }
}
