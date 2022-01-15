package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.client.ParserClient
import ee.bredbrains.tthkapi.model.ParsableUrls
import ee.bredbrains.tthkapi.model.UpdatableEntity
import ee.bredbrains.tthkapi.model.UpdatableEntityCompanion
import ee.bredbrains.tthkapi.repository.BaseEntityRepository

abstract class UpdatableEntityService<T>(
    private val updateTimeService: UpdateTimeService,
    private val repository: BaseEntityRepository<T>,
    private val parserClient: ParserClient<T>,
    private val urls: ParsableUrls
) : BaseEntityService<T>() where T : UpdatableEntity {
    abstract val companion: UpdatableEntityCompanion
    private val isDeprecated: Boolean get() = updateTimeService.isDeprecated(companion)
    private val isEmpty: Boolean get() = repository.findAll().isEmpty()
    private val isUpdateRequired: Boolean get() = isEmpty || isDeprecated

    override fun all(): List<T> {
        return if (isUpdateRequired) updateAndGetLatest() else getLatest()
    }

    private fun captureLastUpdateTime() {
        updateTimeService.captureLastUpdateTime(companion)
    }

    private fun getLatest(): List<T> {
        return repository.findAll()
    }

    private fun update() {
        captureLastUpdateTime()
        val data = parserClient.parse(urls)
        repository.saveAll(data)
    }

    private fun updateAndGetLatest(): List<T> {
        update()
        return getLatest()
    }

    fun <F> all(arg: F): List<T> {
        return if (isUpdateRequired) updateAndGetLatest(arg) else getLatest(arg)
    }

    private fun <F> updateAndGetLatest(arg: F): List<T> {
        update()
        return getLatest(arg)
    }

    internal abstract fun <F> getLatest(arg: F): List<T>
}