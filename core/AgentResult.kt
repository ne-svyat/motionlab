package core

interface AgentResult {

    val agentName: String

    val confidence: Float

    val timestamp: Long

    val summary: String

}
