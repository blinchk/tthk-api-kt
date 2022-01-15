package ee.bredbrains.tthkapi.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidDepartmentException(department: String) :
    RuntimeException("$department cannot be recognized as department")