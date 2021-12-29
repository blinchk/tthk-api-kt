package ee.bredbrains.tthkapi.model

import ee.bredbrains.tthkapi.util.ChangeUtil.determineStatus
import ee.bredbrains.tthkapi.util.ChangeUtil.isStatus
import org.hibernate.annotations.GenericGenerator
import java.text.SimpleDateFormat
import java.util.*
import javax.persistence.*

@Table(name = Change.tableName)
@Entity
class Change {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    var id: String = UUID.randomUUID().toString()
    var date = Date()
    @Column(name = "thkgroup") var group = ""
    var lessons: String? = null
    var teacher: String? = null
    var room: String? = null
    var status: ChangeStatus? = null

    fun assignStatus(statusTrigger: String) {
        if (isStatus(statusTrigger)) {
            this.status = determineStatus(statusTrigger)
        } else {
            this.room = statusTrigger
        }
    }

    companion object : UpdatableEntityCompanion {
        const val tableName = "changes"
        override fun tableName(): String {
            return tableName
        }
    }

    object Factory {
        private const val DATE_PATTERN = "dd.MM.yyyy"
        const val DATE_INDEX = 1
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