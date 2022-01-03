package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.client.ParserClient
import ee.bredbrains.tthkapi.model.ParsableUrls
import ee.bredbrains.tthkapi.model.UpdatableEntity
import ee.bredbrains.tthkapi.model.UpdatableEntityCompanion
import org.springframework.data.jpa.repository.JpaRepository

abstract class UpdatableEntityService<T, K>(
    private val updateTimeService: UpdateTimeService,
    private val repository: JpaRepository<T, K>,
    private val parserClient: ParserClient<T>,
    private val urls: ParsableUrls
) where T : UpdatableEntity {
    abstract val companion: UpdatableEntityCompanion
    private val isDeprecated: Boolean get() = updateTimeService.isDeprecated(companion)
    private val isEmpty: Boolean get() = repository.findAll().isEmpty()
    val isUpdateRequired: Boolean get() = isEmpty || isDeprecated

    fun all(): List<T> {
        return if (isUpdateRequired) updateAndGetLatest() else repository.findAll()
    }

    private fun captureLastUpdateTime() {
        updateTimeService.captureLastUpdateTime(companion)
    }

    private fun getLatest(): List<T> {
        return repository.findAll()
    }

    fun update() {
        captureLastUpdateTime()
        val data = parserClient.parse(urls)
        repository.saveAll(data)
    }

    private fun updateAndGetLatest(): List<T> {
        update()
        return getLatest()
    }

}