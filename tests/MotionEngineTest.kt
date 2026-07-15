package tests

import core.MotionEngine
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

        steps = 15000,
        distanceMeters = 10000f,
        speedKmh = 5.5f,

        cadence = 112f,
        stepLengthCm = 73f,

        intensity = 0.7f,
        confidence = 0.96f

    )


    val engine = MotionEngine(user)


    val report =
        engine.analyze(snapshot)


    println("MOTION ENGINE REPORT")
    println("--------------------")


    report.results.forEach { result ->

        println(result)

    }

}
