package ee.bredbrains.tthkapi.model

import com.fasterxml.jackson.annotation.JsonFormat
import ee.bredbrains.tthkapi.model.Change.Factory.DATE_PATTERN
import ee.bredbrains.tthkapi.util.ChangeUtil
import ee.bredbrains.tthkapi.util.ChangeUtil.determineStatus
import ee.bredbrains.tthkapi.util.ChangeUtil.isStatus
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = Change.tableName)
class Change : UpdatableEntity() {
    @JsonFormat(pattern = DATE_PATTERN)
    var date: Date? = null
    @Column(name = "thkgroup")
    var group: String? = null
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
        const val DATE_PATTERN = "dd.MM.yyyy"
        private const val DATE_INDEX = 1
        private const val GROUP_INDEX = 2
        private const val LESSONS_INDEX = 3
        private const val TEACHER_INDEX = 4

        private const val ROOM_INDEX = 5
        fun fromList(parts: Array<String>): Change? {
            if (parts[DATE_INDEX] == "Kuupäev") return null
            return try {
                Change().apply {
                    date = ChangeUtil.parseDate(parts[DATE_INDEX])
                    group = parts[GROUP_INDEX]
                    lessons = parts[LESSONS_INDEX]
                    teacher = parts[TEACHER_INDEX]
                    assignStatus(parts[ROOM_INDEX])
                }
            } catch (e: ArrayIndexOutOfBoundsException) {
                null
            }
        }
    }
}