package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.model.UpdatableEntity
import ee.bredbrains.tthkapi.model.UpdatableEntityCompanion
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

abstract class UpdatableEntityService<T>(
    private val updateTimeService: UpdateTimeService,
    private val repository: JpaRepository<T, UUID>,
) where T : UpdatableEntity {
    abstract val companion: UpdatableEntityCompanion
    private val isDeprecated: Boolean get() = updateTimeService.isDeprecated(companion)
    private val isEmpty: Boolean get() = repository.findAll().isEmpty()
    val isUpdateRequired: Boolean get() = isEmpty || isDeprecated
    protected fun captureLastUpdateTime() {
        updateTimeService.captureLastUpdateTime(companion)
    }
}