package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.client.ConsultationParserClient
import ee.bredbrains.tthkapi.model.Consultation
import ee.bredbrains.tthkapi.model.Department
import ee.bredbrains.tthkapi.model.UpdatableEntityCompanion
import ee.bredbrains.tthkapi.repository.ConsultationRepository
import ee.bredbrains.tthkapi.util.ConsultationUtil
import org.springframework.stereotype.Service

@Service
class ConsultationService(
    private val consultationRepository: ConsultationRepository,
    updateTimeService: UpdateTimeService,
) : UpdatableEntityService<Consultation>(
    updateTimeService,
    consultationRepository,
    ConsultationParserClient(),
    ConsultationUtil.CONSULTATION_URLS
) {
    override fun <F> getLatest(arg: F): List<Consultation> {
        if (arg is Department) {
            return consultationRepository.findAllByDepartment(arg as Department)
        } else {
            throw IllegalArgumentException()
        }
    }

    override val companion: UpdatableEntityCompanion get() = Consultation.Companion
}