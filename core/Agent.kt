package core

interface Agent<T> {

    fun analyze(
        snapshot: MotionSnapshot
    ): T
}
