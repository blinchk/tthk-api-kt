package ee.bredbrains.tthkapi.model

import ee.bredbrains.tthkapi.model.Group.Companion.tableName
import ee.bredbrains.tthkapi.util.GroupUtil.determineLanguageByCode
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = tableName)
class Group : UpdatableEntity() {
    var code = ""
    var department: Department? = null
    var language: Language? = null

    @Embedded
    var headteacher: Headteacher? = null

    fun determineLanguage() {
        language = determineLanguageByCode(code)
    }

    companion object : UpdatableEntityCompanion {
        const val tableName = "studygroups"

        override fun tableName(): String {
            return tableName
        }
    }

    object Factory {
        private const val CODE_INDEX = 0
        private const val LANGUAGE_INDEX = 1
        private const val HEADTEACHER_NAME_INDEX = 2
        private const val HEADTEACHER_CONTACT_INDEX = 3

        fun fromList(parts: Array<String>): Group? {
            if (parts.count() < 4 || parts[CODE_INDEX] == "Õppegrupp") return null
            return Group().apply {
                code = parts[CODE_INDEX]
                language = if (parts[LANGUAGE_INDEX] == "V") Language.RUSSIAN else Language.ESTONIAN
                headteacher = Headteacher().apply {
                    name = parts[HEADTEACHER_NAME_INDEX]
                    contact = parts[HEADTEACHER_CONTACT_INDEX]
                }
            }
        }
    }
}