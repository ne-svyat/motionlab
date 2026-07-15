package core

import agents.EnergyAgent
import agents.PatternAgent
import agents.TerrainAgent


class MotionEngine(

    user: UserProfile

) {


    private val agents = listOf(

        PatternAgent(),

        EnergyAgent(user),

        TerrainAgent()

    )


    fun analyze(
        snapshot: MotionSnapshot
    ): AnalysisReport {


        val results = agents.map { agent ->

            agent.analyze(snapshot)

        }


        return AnalysisReport(

            results = results

        )

    }
}
