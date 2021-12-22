package ee.bredbrains.tthkapi.util

import ee.bredbrains.tthkapi.model.Language
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GroupUtilTest {
    @Test
    fun `determine Russian language by code`() {
        val expected = Language.RUSSIAN
        assertEquals(expected, GroupUtil.determineLanguageByCode("TARpv19"))
        assertEquals(expected, GroupUtil.determineLanguageByCode("VLOGpv21"))
        assertEquals(expected, GroupUtil.determineLanguageByCode("LOGITpv21"))
        assertEquals(expected, GroupUtil.determineLanguageByCode("VLOGgv20"))
    }

    @Test
    fun `determine Estonian language by code`() {
        val expected = Language.ESTONIAN
        assertEquals(expected, GroupUtil.determineLanguageByCode("MÜKgeMS21"))
        assertEquals(expected, GroupUtil.determineLanguageByCode("KRRgeÕ21"))
        assertEquals(expected, GroupUtil.determineLanguageByCode("MEHpe19"))
        assertEquals(expected, GroupUtil.determineLanguageByCode("ROOpe21"))
    }
}