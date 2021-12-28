package ee.bredbrains.tthkapi.repository

import ee.bredbrains.tthkapi.model.UpdateTime
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UpdateTimeRepository : JpaRepository<UpdateTime, UUID> {
    fun findByTableName(tableName: String): UpdateTime
}