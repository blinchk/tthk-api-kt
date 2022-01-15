package ee.bredbrains.tthkapi.model

import javax.persistence.Embeddable

@Embeddable
class Headteacher {
    var name: String? = null
    var contact: String? = null
}