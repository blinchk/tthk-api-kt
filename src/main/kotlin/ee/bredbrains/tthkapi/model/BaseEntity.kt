package ee.bredbrains.tthkapi.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    var id: String = UUID.randomUUID().toString()
}