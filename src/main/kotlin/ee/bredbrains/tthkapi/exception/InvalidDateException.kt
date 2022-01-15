package ee.bredbrains.tthkapi.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidDateException(date: String) : RuntimeException("$date cannot be recognized as date")