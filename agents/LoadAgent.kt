package agents

import core.Agent
import core.CarryingProfile
import core.MotionSnapshot


data class LoadResult(

    val extraWeightKg: Float,
    val loadLevel: String,
    val impactPercent: Float

)


class LoadAgent(
    private val carrying: CarryingProfile
) : Agent {


    override fun analyze(
        snapshot: MotionSnapshot
    ): Any {


        val extra =
            carrying.backpackKg


        val impact =
            extra * 1.5f


        val level =
            when {

                extra < 2 ->
                    "LOW"

                extra < 7 ->
                    "MEDIUM"

                else ->
                    "HIGH"

            }


        return LoadResult(

            extraWeightKg = extra,
            loadLevel = level,
            impactPercent = impact

        )
    }
}
