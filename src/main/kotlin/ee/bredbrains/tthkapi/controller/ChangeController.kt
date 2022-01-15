package ee.bredbrains.tthkapi.controller

import ee.bredbrains.tthkapi.model.Change
import ee.bredbrains.tthkapi.service.ChangeService
import ee.bredbrains.tthkapi.util.ChangeUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/changes")
class ChangeController(private val changeService: ChangeService) : BaseEntityController<Change>(changeService) {
    @GetMapping("/{_date}")
    fun byDate(
        @PathVariable _date: String
    ): List<Change> {
        val date = ChangeUtil.parseDate(_date)
        return changeService.all(date)
    }
}