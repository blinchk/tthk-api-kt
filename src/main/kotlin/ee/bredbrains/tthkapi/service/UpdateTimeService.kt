package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.model.UpdatableEntityCompanion
import ee.bredbrains.tthkapi.model.UpdateTime
import ee.bredbrains.tthkapi.repository.UpdateTimeRepository
import ee.bredbrains.tthkapi.util.UpdateTimeUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class UpdateTimeService(private val updateTimeRepository: UpdateTimeRepository) {
    fun lastUpdateTime(entity : UpdatableEntityCompanion) = updateTimeRepository.findByTableName(entity.tableName())

    fun captureLastUpdateTime(entity :  UpdatableEntityCompanion): UpdateTime {
        val now = Date()
        val updateTime = UpdateTime(entity.tableName(), now)
        return updateTimeRepository.save(updateTime)
    }

    fun isDeprecated(entity: UpdatableEntityCompanion): Boolean {
        val now = Date()
        val calendar = Calendar.getInstance()
        val lastUpdateTime = lastUpdateTime(entity).date ?: return true
        calendar.time = lastUpdateTime
        calendar.add(Calendar.HOUR, UpdateTimeUtil.tableUpdateTime(entity.tableName()))
        val expectedUpdateTime = calendar.time
        return now.after(expectedUpdateTime)
    }
}
