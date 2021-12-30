package ee.bredbrains.tthkapi.util

import java.util.*

object CalendarUtil {
    private const val LESSONS_BEGINNING_HOURS = 8
    private const val LESSONS_BEGINNING_MINUTES = 30
    private const val LESSONS_BEGINNING_SECONDS = 0
    private const val LESSONS_BEGINNING_MILLISECONDS = 0

    fun Calendar.setDefaults() {
        this.set(Calendar.HOUR_OF_DAY, LESSONS_BEGINNING_HOURS)
        this.set(Calendar.MINUTE, LESSONS_BEGINNING_MINUTES)
        this.set(Calendar.SECOND, LESSONS_BEGINNING_SECONDS)
        this.set(Calendar.MILLISECOND, LESSONS_BEGINNING_MILLISECONDS)
    }
}