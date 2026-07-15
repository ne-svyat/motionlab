package core

import agents.PatternAgent
import agents.PatternResult

class MotionEngine {

    private val patternAgent = PatternAgent()

    fun analyze(
        snapshot: MotionSnapshot
    ): PatternResult {

        return patternAgent.analyze(
            snapshot
        )
    }
}
