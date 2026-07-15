package core

import agents.EnergyAgent
import agents.PatternAgent
import agents.TerrainAgent
import agents.LoadAgent


class MotionEngine(

    user: UserProfile,
    carrying: CarryingProfile

) {


    private val agents = listOf(

        PatternAgent(),

        EnergyAgent(user),

        TerrainAgent(),

        LoadAgent(carrying)

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
