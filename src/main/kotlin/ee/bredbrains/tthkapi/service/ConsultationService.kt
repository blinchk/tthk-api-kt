package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.client.ConsultationParserClient
import ee.bredbrains.tthkapi.model.Consultation
import ee.bredbrains.tthkapi.model.Department
import ee.bredbrains.tthkapi.model.UpdatableEntityCompanion
import ee.bredbrains.tthkapi.repository.ConsultationRepository
import ee.bredbrains.tthkapi.util.ConsultationUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class ConsultationService(
    private val consultationRepository: ConsultationRepository,
    updateTimeService: UpdateTimeService,
) : UpdatableEntityService<Consultation, UUID>(updateTimeService,
    consultationRepository,
    ConsultationParserClient(),
    ConsultationUtil.CONSULTATION_URLS) {
    fun allByDepartment(department: Department): List<Consultation> {
        return if (isUpdateRequired) updateAndGetLatest(department) else consultationRepository.findAllByDepartment(
            department)
    }

    private fun updateAndGetLatest(department: Department): List<Consultation> {
        update()
        return getLatestByDepartment(department)
    }

    private fun getLatestByDepartment(department: Department): List<Consultation> {
        return consultationRepository.findAllByDepartment(department)
    }

    override val companion: UpdatableEntityCompanion get() = Consultation.Companion
}