package core

data class UserProfile(

    val weightKg: Float,
    val heightCm: Float,
    val age: Int

) {

    fun basalCaloriesPerDay(): Float {

        return (
            10 * weightKg +
            6.25f * heightCm -
            5 * age +
            5
        )

    }
}
