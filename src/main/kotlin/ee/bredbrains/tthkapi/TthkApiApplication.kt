package ee.bredbrains.tthkapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TthkApiApplication

fun main(args: Array<String>) {
    runApplication<TthkApiApplication>(*args)
}
