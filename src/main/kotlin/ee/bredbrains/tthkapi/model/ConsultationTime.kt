package ee.bredbrains.tthkapi.model

import javax.persistence.Embeddable

@Embeddable
class ConsultationTime {
    var weekday: Weekday? = null
    var timeInterval: String? = null
}
