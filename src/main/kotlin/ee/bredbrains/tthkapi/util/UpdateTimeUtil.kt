package ee.bredbrains.tthkapi.util

object UpdateTimeUtil {
    private val tableUpdateTimesInHours: Map<String, Int> = mapOf(
        "changes" to 6,
        "study_groups" to 72,
    )

    fun tableUpdateTime(table: String) = tableUpdateTimesInHours.getOrDefault(table, 24)
}