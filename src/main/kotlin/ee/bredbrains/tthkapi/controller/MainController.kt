package ee.bredbrains.tthkapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@RestController
@RequestMapping("/")
class MainController {
    @GetMapping
    fun redirectToSchoolPage(): RedirectView {
        return RedirectView("https://tthk.ee/")
    }
}