package ee.bredbrains.tthkapi.util

import ee.bredbrains.tthkapi.model.Language

object GroupUtil {
    private const val ESTONIAN_LANGUAGE_TRIGGER = 'e'
    private const val RUSSIAN_LANGUAGE_TRIGGER = 'v'
    private const val SEARCH_LAST_INDEX = 6


    fun determineLanguageByCode(code: String): Language {
        val isRussian = getTriggerPosition(code, RUSSIAN_LANGUAGE_TRIGGER)
        val isEstonian = getTriggerPosition(code, ESTONIAN_LANGUAGE_TRIGGER)
        return if (isRussian > isEstonian) Language.RUSSIAN else Language.ESTONIAN
    }

    private fun getTriggerPosition(code: String, trigger: Char) =
        code.substring(0..SEARCH_LAST_INDEX).lastIndexOf(trigger)

    const val GROUPS_URL = "https://www.tthk.ee/oppetoo/tunniplaan/ruhmajuhatajad/"
}