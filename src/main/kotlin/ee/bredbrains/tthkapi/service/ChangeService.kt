package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.client.ChangeParserClient
import ee.bredbrains.tthkapi.model.Change
import ee.bredbrains.tthkapi.repository.ChangeRepository
import ee.bredbrains.tthkapi.util.ParserUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChangeService(private val changeRepository: ChangeRepository, private val updateTimeService: UpdateTimeService) {
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
        val changes = ChangeParserClient().parse(listOf(ParserUtil.CHANGES_URL))
        changeRepository.saveAll(changes)
    }

    private fun captureLastUpdateTime() {
        updateTimeService.captureLastUpdateTime(Change)
    }

    private val isDeprecated: Boolean get() = updateTimeService.isDeprecated(Change)
    private val isEmpty: Boolean get() = changeRepository.findAll().isEmpty()
    private val isUpdateRequired: Boolean get() = isEmpty || isDeprecated
}