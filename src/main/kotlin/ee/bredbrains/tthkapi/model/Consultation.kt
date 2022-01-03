package ee.bredbrains.tthkapi.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "consultations")
class Consultation : UpdatableEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    var id: String = UUID.randomUUID().toString()
    var teacher: String? = null
    var room: String? = null
    var email: String? = null
    var department: Department? = null

    @Embedded
    var time: ConsultationTime? = null

    companion object : UpdatableEntityCompanion {
        const val tableName = "consultation"
        override fun tableName(): String {
            return tableName
        }
    }

    object Factory {
        private const val TEACHER_INDEX = 0
        private const val EMAIL_INDEX = 1
        private const val ROOM_INDEX = 2
        private const val DEFAULT_START_INDEX_WITHOUT_EMAIL = 3
        private const val DEFAULT_START_INDEX_WITH_EMAIL = 4

        fun fromList(parts: Array<String>, department: Department): List<Consultation> {
            if (parts.size < 3) return arrayListOf()
            if (parts[TEACHER_INDEX] == "Õpetaja") return arrayListOf()
            val containsEmail = containsEmail(parts[EMAIL_INDEX])
            val timesFromIndex =
                if (containsEmail) DEFAULT_START_INDEX_WITH_EMAIL else DEFAULT_START_INDEX_WITHOUT_EMAIL
            val maximumIndex = parts.size
            val timeIntervals = ConsultationTime.Factory.eachFromList(parts.copyOfRange(timesFromIndex, maximumIndex))
            val consultations = ArrayList<Consultation>()
            timeIntervals.forEach {
                run {
                    consultations.add(Consultation().apply {
                        teacher = parts[TEACHER_INDEX]
                        room = if (containsEmail) parts[ROOM_INDEX] else parts[EMAIL_INDEX]
                        email = if (containsEmail) parts[EMAIL_INDEX] else null
                        this.department = department
                        this.time = it
                    })
                }
            }
            return consultations
        }

        private fun containsEmail(emailToValidate: String): Boolean {
            val pattern = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
            return pattern.matches(emailToValidate)
        }
    }
}
