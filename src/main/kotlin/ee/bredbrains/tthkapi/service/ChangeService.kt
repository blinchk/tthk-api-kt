package ee.bredbrains.tthkapi.service

import ee.bredbrains.tthkapi.repository.ChangeRepository
import org.springframework.stereotype.Service

@Service
class ChangeService(private val changeRepository: ChangeRepository) {

}