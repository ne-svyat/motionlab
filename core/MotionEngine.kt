package core

import agents.EnergyAgent
import agents.PatternAgent
import core.UserProfile


class MotionEngine(
    user: UserProfile
) {


    private val agents = listOf(

        PatternAgent(),

        EnergyAgent(user)

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
