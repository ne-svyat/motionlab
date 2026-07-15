package tests

import core.MotionEngine
import core.MotionSnapshot

fun main() {

    val snapshot = MotionSnapshot(
        timestamp = System.currentTimeMillis(),

        steps = 15000,
        distanceMeters = 10000f,
        speedKmh = 5.5f,

        cadence = 112f,
        stepLengthCm = 73f,

        intensity = 0.7f,
        confidence = 0.96f
    )


    val engine = MotionEngine()

    val result = engine.analyze(
        snapshot = snapshot,
        averageSteps = 9000
    )


    println("MOTION ENGINE")
    println("----------------")
    println("Agent: PatternAgent")
    println("Status: ${result.status}")
    println("Change: ${result.activityChangePercent}%")
    println(result.message)
}
