package ee.bredbrains.tthkapi.repository

import ee.bredbrains.tthkapi.model.UpdateTime
import org.springframework.stereotype.Repository

@Repository
interface UpdateTimeRepository : BaseEntityRepository<UpdateTime> {
    fun findByTableName(tableName: String): UpdateTime
}