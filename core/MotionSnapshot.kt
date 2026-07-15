package core

data class MotionSnapshot(
    val timestamp: Long,

    // Основные данные движения
    val steps: Int,
    val distanceMeters: Float,
    val speedKmh: Float,

    // Биомеханика
    val cadence: Float,
    val stepLengthCm: Float,

    // Интенсивность движения
    val intensity: Float,

    // Насколько мы уверены в данных
    val confidence: Float
)
