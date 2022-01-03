package ee.bredbrains.tthkapi.repository;

import ee.bredbrains.tthkapi.model.Consultation
import ee.bredbrains.tthkapi.model.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ConsultationRepository : JpaRepository<Consultation, UUID> {
    fun findAllByDepartment(department: Department): List<Consultation>
}