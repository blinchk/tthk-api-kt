package ee.bredbrains.tthkapi.repository;

import ee.bredbrains.tthkapi.model.Consultation
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ConsultationRepository : JpaRepository<Consultation, UUID> {
}