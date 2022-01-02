package ee.bredbrains.tthkapi.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "consultations")
class Consultation {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    var id: String = UUID.randomUUID().toString()
    val teacher: String? = null
    val room: String? = null
    val email: String? = null
    val department: Department? = null
    @Embedded val time: ConsultationTime? = null
}
