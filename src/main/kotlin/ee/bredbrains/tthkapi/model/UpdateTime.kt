package ee.bredbrains.tthkapi.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name="update_times")
class UpdateTime() {
    constructor(tableName: String, date: Date) : this() {
        this.tableName = tableName
        this.date = date
    }

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    var id: String = UUID.randomUUID().toString()
    var tableName: String? = null
    var date: Date? = null
}