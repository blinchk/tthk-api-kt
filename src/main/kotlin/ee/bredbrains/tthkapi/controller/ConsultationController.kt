package ee.bredbrains.tthkapi.controller

import ee.bredbrains.tthkapi.model.Consultation
import ee.bredbrains.tthkapi.service.ConsultationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/consultations")
class ConsultationController(private val consultationService: ConsultationService) {
    @GetMapping
    fun all(): List<Consultation> {
        return consultationService.all()
    }
}