package ee.bredbrains.tthkapi.util

import java.util.*

object CalendarUtil {
    fun Calendar.setDefaults() {
        this.set(Calendar.HOUR_OF_DAY, 8)
        this.set(Calendar.MINUTE, 30)
        this.set(Calendar.SECOND, 0)
        this.set(Calendar.MILLISECOND, 0)
    }
}