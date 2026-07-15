package agents

import core.AnalysisReport


data class DecisionResult(

    val status: String,
    val score: Int,
    val message: String

)


class DecisionAgent {


    fun analyze(
        report: AnalysisReport
    ): DecisionResult {


        var score = 0


        var messageParts = mutableListOf<String>()


        report.results.forEach { result ->


            when (result) {


                is PatternResult -> {

                    if (result.status == "HIGH_ACTIVITY") {

                        score += 20

                        messageParts.add(
                            "Высокая активность"
                        )

                    }

                }


                is EnergyResult -> {

                    if (result.activeCalories > 600) {

                        score += 30

                        messageParts.add(
                            "Большой расход энергии"
                        )

                    }

                }


                is LoadResult -> {

                    if (result.loadLevel == "HIGH" ||
                        result.loadLevel == "MEDIUM") {

                        score += 20

                        messageParts.add(
                            "Дополнительная нагрузка"
                        )

                    }

                }


                is TerrainResult -> {

                    if (result.difficulty >= 7) {

                        score += 30

                        messageParts.add(
                            "Сложный рельеф"
                        )

                    }

                }

            }

        }


        val status = when {

            score >= 70 ->
                "HIGH_LOAD_DAY"


            score >= 40 ->
                "MODERATE_LOAD_DAY"


            else ->
                "NORMAL_DAY"

        }


        return DecisionResult(

            status = status,

            score = score,

            message = messageParts.joinToString(
                separator = ". "
            )

        )

    }

}
