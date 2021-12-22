package ee.bredbrains.tthkapi.client

import ee.bredbrains.tthkapi.util.ChangeUtil.CHANGES_URL
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ChangeParserClientTest {
    @Test
    fun `try to parse changes`() {
        val changes = ChangeParserClient().parse(CHANGES_URL)
        assertTrue(changes.isNotEmpty())
    }
}