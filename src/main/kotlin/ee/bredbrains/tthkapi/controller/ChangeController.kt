package ee.bredbrains.tthkapi.controller

import ee.bredbrains.tthkapi.model.Change
import ee.bredbrains.tthkapi.service.ChangeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/changes")
class ChangeController(private val changeService: ChangeService) {
    @GetMapping
    fun all(): List<Change> {
        return changeService.all()
    }

    @GetMapping("/{day}-{month}-{year}", )
    fun byDate(
        @PathVariable day: String,
        @PathVariable month: String,
        @PathVariable year: String,
    ): List<Change> {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, day.toInt())
        calendar.set(Calendar.MONTH, month.toInt())
        calendar.set(Calendar.YEAR, year.toInt())
        return changeService.byDate(calendar.time)
    }
}