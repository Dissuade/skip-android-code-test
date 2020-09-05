package ca.skipthedishes.codetest.model

data class Restaurant(
    val name: String,
    val image: Int,
    val score: Double,
    val estimate: TimeEstimate
)

data class TimeEstimate(
    val min: Int,
    val max: Int
) {
    override fun toString(): String {
        return "$min - $max mins"
    }
}
