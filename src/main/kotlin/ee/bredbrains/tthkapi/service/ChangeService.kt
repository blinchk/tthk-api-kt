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
class ChangeService(private val changeRepository: ChangeRepository, updateTimeService: UpdateTimeService): UpdatableEntityService<Change>(updateTimeService, changeRepository) {
    fun all(): List<Change> {
        return if (isUpdateRequired) updateAndGetLatestChanges() else changeRepository.findAll()
    }

    fun allByDate(date: Date): List<Change> {
        return if (isUpdateRequired) updateAndGetLatestChanges(date) else changeRepository.findAllByDate(date)
    }

    private fun updateAndGetLatestChanges(): List<Change> {
        updateChanges()
        return getLatestChanges()
    }

    private fun updateAndGetLatestChanges(date: Date): List<Change> {
        updateChanges()
        return getLatestChangesByDate(date)
    }

    private fun getLatestChanges(): List<Change> {
        return changeRepository.findAll()
    }

    private fun getLatestChangesByDate(date: Date): List<Change> {
        return changeRepository.findAllByDate(date)
    }

    private fun updateChanges() {
        captureLastUpdateTime()
        val urls = ParsableUrls(null, CHANGES_URL)
        val changes = ChangeParserClient().parse(urls)
        changeRepository.saveAll(changes)
    }

    override val companion: UpdatableEntityCompanion get() = Change.Companion
}