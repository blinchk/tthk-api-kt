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
) : UpdatableEntityService<Change>(
    updateTimeService,
    changeRepository,
    ChangeParserClient(),
    ParsableUrls(null, CHANGES_URL)
) {
    override val companion: UpdatableEntityCompanion get() = Change.Companion
    override fun <F> getLatest(arg: F): List<Change> {
        if (arg is Date) {
            return changeRepository.findAllByDate(arg as Date)
        } else {
            throw IllegalArgumentException()
        }
    }
}