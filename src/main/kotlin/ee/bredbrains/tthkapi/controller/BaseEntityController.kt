package ee.bredbrains.tthkapi.controller

import ee.bredbrains.tthkapi.model.BaseEntity
import ee.bredbrains.tthkapi.service.BaseEntityService
import org.springframework.web.bind.annotation.GetMapping

abstract class BaseEntityController<T>(private val service: BaseEntityService<T>) where T : BaseEntity {
    @GetMapping
    fun all(): List<T> {
        return service.all()
    }
}