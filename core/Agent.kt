package core

interface Agent {

    fun analyze(
        snapshot: MotionSnapshot
    ): AgentResult

}
