package tests

import core.CarryingProfile
import core.MotionEngine
import core.MotionSnapshot
import core.UserProfile


fun main() {


    val user = UserProfile(

        weightKg = 74f,
        heightCm = 169f,
        age = 32

    )


    val carrying = CarryingProfile(

        backpackKg = 6.5f

    )


    val snapshot = MotionSnapshot(

        timestamp = System.currentTimeMillis(),

        steps = 18000,
        distanceMeters = 12000f,
        speedKmh = 5.3f,

        cadence = 110f,
        stepLengthCm = 72f,

        intensity = 0.75f,
        confidence = 0.95f

    )


    val engine = MotionEngine(

        user,
        carrying

    )


    val report = engine.analyze(snapshot)


    println("MOTION ENGINE REPORT")
    println("--------------------")


    report.results.forEach { result ->

        println(result)

    }

}
