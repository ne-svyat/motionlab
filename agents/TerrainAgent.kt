package agents

import core.Agent
import core.MotionSnapshot


data class TerrainResult(

    val terrain: String,
    val difficulty: Int,
    val description: String

)


class TerrainAgent : Agent {


    override fun analyze(
        snapshot: MotionSnapshot
    ): Any {


        val terrain =
            when {

                snapshot.intensity > 0.8f ->
                    "HARD_TERRAIN"


                snapshot.speedKmh < 3.5f &&
                snapshot.intensity > 0.5f ->
                    "SLOPE_OR_STAIRS"


                else ->
                    "NORMAL_WALK"

            }


        val difficulty =
            when (terrain) {

                "HARD_TERRAIN" ->
                    9

                "SLOPE_OR_STAIRS" ->
                    7

                else ->
                    3

            }


        val description =
            when (terrain) {

                "HARD_TERRAIN" ->
                    "Высокая нагрузка: возможен сложный рельеф"


                "SLOPE_OR_STAIRS" ->
                    "Медленное движение с нагрузкой: возможен подъём"


                else ->
                    "Обычное движение"

            }


        return TerrainResult(

            terrain = terrain,
            difficulty = difficulty,
            description = description

        )
    }
}
