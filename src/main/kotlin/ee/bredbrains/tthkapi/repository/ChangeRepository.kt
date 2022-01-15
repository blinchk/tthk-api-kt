package ee.bredbrains.tthkapi.repository

import ee.bredbrains.tthkapi.model.Change
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ChangeRepository : BaseEntityRepository<Change> {
    fun findAllByDate(date: Date): List<Change>
}