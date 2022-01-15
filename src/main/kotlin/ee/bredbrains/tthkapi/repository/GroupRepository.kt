package ee.bredbrains.tthkapi.repository

import ee.bredbrains.tthkapi.model.Group
import ee.bredbrains.tthkapi.model.Language
import org.springframework.stereotype.Repository

@Repository
interface GroupRepository : BaseEntityRepository<Group> {
    fun findAllByLanguage(language: Language): List<Group>
}