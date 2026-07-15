package tests

import agents.PatternAgent
import core.MotionSnapshot

fun main() {

    val today = MotionSnapshot(
        timestamp = System.currentTimeMillis(),

        steps = 12000,
        distanceMeters = 8500f,
        speedKmh = 5.2f,

        cadence = 110f,
        stepLengthCm = 71f,

        intensity = 0.65f,
        confidence = 0.95f
    )


    val agent = PatternAgent()

    val result = agent.analyze(
        current = today,
        averageSteps = 8000
    )


    println("PATTERN ANALYSIS")
    println("----------------")
    println("Status: ${result.status}")
    println("Change: ${result.activityChangePercent}%")
    println(result.message)
}
