package ee.bredbrains.tthkapi.model

import ee.bredbrains.tthkapi.util.GroupUtil.determineLanguageByCode
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "studygroup")
class Group {
    @Id
    @Column(name = "id", nullable = false)
    var id: UUID? = null
    var code = ""
    var department: Department? = null
    var language: Language? = null

    fun determineLanguage() {
        language = determineLanguageByCode(code)
    }
}