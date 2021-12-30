package ee.bredbrains.tthkapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "TTHK API", version = "1.0", description = "Tallinna Tööstushariduskeskus API"))
class TthkApiApplication

fun main(args: Array<String>) {
    runApplication<TthkApiApplication>(*args)
}
