package agents

import core.Agent
import core.MotionSnapshot
import core.UserProfile


data class EnergyResult(

    val basalCalories: Float,
    val activeCalories: Float,
    val totalCalories: Float,
    val level: String

)


class EnergyAgent(
    private val user: UserProfile
) : Agent<EnergyResult> {


    override fun analyze(
        snapshot: MotionSnapshot
    ): EnergyResult {


        val basal =
            user.basalCaloriesPerDay()


        val active =
            user.weightKg *
            snapshot.distanceMeters / 1000f *
            0.9f


        val total =
            basal + active


        val level =
            when {

                active < 200 ->
                    "LOW"

                active < 600 ->
                    "MEDIUM"

                else ->
                    "HIGH"

            }


        return EnergyResult(

            basalCalories = basal,
            activeCalories = active,
            totalCalories = total,
            level = level

        )
    }
}
