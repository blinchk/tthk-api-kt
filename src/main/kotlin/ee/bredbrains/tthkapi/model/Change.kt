package ee.bredbrains.tthkapi.model

import ee.bredbrains.tthkapi.util.ChangeUtil.determineStatus
import ee.bredbrains.tthkapi.util.ChangeUtil.isStatus
import java.text.SimpleDateFormat
import java.util.*
import javax.persistence.*

@Table(name = "changes")
@Entity
class Change {
    @Id
    @Column(nullable = false)
    var id: UUID? = null
    var date = Date()
    var group = ""
    var lessons = ""
    var teacher = ""
    lateinit var room: String
    lateinit var status: ChangeStatus

    fun assignStatus(statusTrigger: String) {
        if (isStatus(statusTrigger)) {
            this.status = determineStatus(statusTrigger)
        } else {
            this.room = statusTrigger
        }
    }

    fun dateEquals(date: Date) = this.date == date
    
    companion object Factory {
        private const val DATE_PATTERN = "dd.MM.yyyy"

        private const val DATE_INDEX = 1
        private const val GROUP_INDEX = 2
        private const val LESSONS_INDEX = 3
        private const val TEACHER_INDEX = 4
        private const val ROOM_INDEX = 5

        fun fromList(parts: Array<String>): Change {
            return Change().apply {
                date = SimpleDateFormat(DATE_PATTERN).parse(parts[DATE_INDEX])
                group = parts[GROUP_INDEX]
                lessons = parts[LESSONS_INDEX]
                teacher = parts[TEACHER_INDEX]
                assignStatus(parts[ROOM_INDEX])
            }
        }
    }
}