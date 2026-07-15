package core

class EventBus {

    private val events = mutableListOf<MotionEvent>()

    fun publish(event: MotionEvent) {
        events.add(event)
    }

    fun getEvents(): List<MotionEvent> {
        return events.toList()
    }

    fun clear() {
        events.clear()
    }
}
