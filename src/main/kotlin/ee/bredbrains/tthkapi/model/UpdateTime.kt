package ee.bredbrains.tthkapi.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="update_times")
class UpdateTime {
    @Id
    @Column(name = "id", nullable = false)
    var id: UUID? = null
    var table: String? = null
    var updateTime: Date? = null
}