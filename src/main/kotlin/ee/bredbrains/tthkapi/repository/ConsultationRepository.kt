package ee.bredbrains.tthkapi.repository

import ee.bredbrains.tthkapi.model.Consultation
import ee.bredbrains.tthkapi.model.Department
import org.springframework.stereotype.Repository

@Repository
interface ConsultationRepository : BaseEntityRepository<Consultation> {
    fun findAllByDepartment(department: Department): List<Consultation>
}