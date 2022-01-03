package ee.bredbrains.tthkapi.model

import javax.persistence.Embeddable

@Embeddable
class ConsultationTime {
    var weekday: Weekday? = null
    var timeInterval: String? = null

    object Factory {
        fun eachFromList(parts: Array<String>): List<ConsultationTime> {
            val times = ArrayList<ConsultationTime?>()
            parts.forEachIndexed { index, part -> times.add(fromTime(Weekday.values()[index], part)) }
            return times.filterNotNull()
        }

        private fun fromTime(weekday: Weekday, timeInterval: String): ConsultationTime? {
            if (timeInterval.isEmpty()) return null
            return ConsultationTime().apply {
                this.weekday = weekday
                this.timeInterval = timeInterval
            }
        }
    }
}
