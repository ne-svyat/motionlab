package tests

import agents.EnergyAgent
import core.MotionSnapshot
import core.UserProfile


fun main() {


    val user = UserProfile(

        weightKg = 74f,
        heightCm = 169f,
        age = 32

    )


    val snapshot = MotionSnapshot(

        timestamp = System.currentTimeMillis(),

        steps = 18000,
        distanceMeters = 12000f,
        speedKmh = 5.3f,

        cadence = 110f,
        stepLengthCm = 72f,

        intensity = 0.7f,
        confidence = 0.95f

    )


    val agent = EnergyAgent(user)


    val result = agent.analyze(snapshot)


    println("ENERGY ANALYSIS")
    println("----------------")
    println("Basal: ${result.basalCalories}")
    println("Active: ${result.activeCalories}")
    println("Total: ${result.totalCalories}")
    println("Level: ${result.level}")

}
