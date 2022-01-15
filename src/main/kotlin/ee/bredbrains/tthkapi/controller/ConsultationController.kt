package ee.bredbrains.tthkapi.controller

import ee.bredbrains.tthkapi.exception.InvalidDepartmentException
import ee.bredbrains.tthkapi.model.Consultation
import ee.bredbrains.tthkapi.model.Department
import ee.bredbrains.tthkapi.service.ConsultationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/consultations")
class ConsultationController(private val consultationService: ConsultationService) :
    BaseEntityController<Consultation>(consultationService) {
    @GetMapping("/{_department}")
    fun allByDepartment(@PathVariable _department: String): List<Consultation> {
        val recognizedDepartment: Department
        try {
            recognizedDepartment = Department.valueOf(_department.uppercase())
        } catch (e: IllegalArgumentException) {
            throw InvalidDepartmentException(_department)
        }
        return consultationService.all(recognizedDepartment)
    }
}