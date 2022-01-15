package ee.bredbrains.tthkapi.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "update_times")
class UpdateTime() : BaseEntity() {
    constructor(tableName: String, date: Date) : this() {
        this.tableName = tableName
        this.date = date
    }

    var tableName: String? = null
    var date: Date? = null
}