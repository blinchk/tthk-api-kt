package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.client.GroupParserClient
import ee.bredbrains.tthkapi.model.Group
import ee.bredbrains.tthkapi.model.Language
import ee.bredbrains.tthkapi.model.ParsableUrls
import ee.bredbrains.tthkapi.model.UpdatableEntityCompanion
import ee.bredbrains.tthkapi.repository.GroupRepository
import ee.bredbrains.tthkapi.util.GroupUtil.GROUPS_URL
import org.springframework.stereotype.Service

@Service
class GroupService(
    private val groupRepository: GroupRepository,
    updateTimeService: UpdateTimeService
) :
    UpdatableEntityService<Group>(
        updateTimeService,
        groupRepository,
        GroupParserClient(),
        ParsableUrls(null, GROUPS_URL)
    ) {
    override val companion: UpdatableEntityCompanion = Group.Companion

    override fun <F> getLatest(arg: F): List<Group> {
        if (arg is Language) {
            return groupRepository.findAllByLanguage(arg as Language)
        } else {
            throw IllegalArgumentException()
        }
    }
}
