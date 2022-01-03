package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.client.ChangeParserClient
import ee.bredbrains.tthkapi.model.Change
import ee.bredbrains.tthkapi.model.ParsableUrls
import ee.bredbrains.tthkapi.model.UpdatableEntityCompanion
import ee.bredbrains.tthkapi.repository.ChangeRepository
import ee.bredbrains.tthkapi.util.ChangeUtil.CHANGES_URL
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChangeService(
    private val changeRepository: ChangeRepository,
    updateTimeService: UpdateTimeService,
) : UpdatableEntityService<Change, UUID>(updateTimeService,
    changeRepository,
    ChangeParserClient(),
    ParsableUrls(null, CHANGES_URL)) {
    fun findAllByDate(date: Date): List<Change> {
        return if (isUpdateRequired) updateAndGetLatest(date) else changeRepository.findAllByDate(date)
    }

    private fun updateAndGetLatest(date: Date): List<Change> {
        update()
        return getLatestByDate(date)
    }

    private fun getLatestByDate(date: Date): List<Change> {
        return changeRepository.findAllByDate(date)
    }

    override val companion: UpdatableEntityCompanion get() = Change.Companion
}