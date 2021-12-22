package ee.bredbrains.tthkapi.repository;

import ee.bredbrains.tthkapi.model.Change
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ChangeRepository : JpaRepository<Change, UUID> {
}