package ee.bredbrains.tthkapi.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ChangeTest {
    @Test
    fun `test Dropped Out status is assigned`() {
        val expected = ChangeStatus.DROPPED_OUT
        val change = Change()
        val statusTrigger = "jääb ära"
        change.assignStatus(statusTrigger)
        assertEquals(expected, change.status)
    }

    @Test
    fun `test Lunch status is assigned`() {
        val expected = ChangeStatus.LUNCH
        val change = Change()
        val statusTrigger = "söögivahetund"
        change.assignStatus(statusTrigger)
        assertEquals(expected, change.status)
    }

    @Test
    fun `test Homework status is assigned`() {
        val expected = ChangeStatus.HOMEWORK
        val change = Change()
        val statusTrigger = "iseseisev töö kodus"
        change.assignStatus(statusTrigger)
        assertEquals(expected, change.status)
    }

    @Test
    fun `test room B148 is assigned`() {
        val expected = "B148"
        val change = Change()
        val statusTrigger = "B148"
        change.assignStatus(statusTrigger)
        assertEquals(expected, change.room)
    }

    @Test
    fun `test room E10 is assigned`() {
        val expected = "E10"
        val change = Change()
        val statusTrigger = "E10"
        change.assignStatus(statusTrigger)
        assertEquals(expected, change.room)
    }

    @Test
    fun `test room A123 is assigned`() {
        val expected = "A123"
        val change = Change()
        val statusTrigger = "A123"
        change.assignStatus(statusTrigger)
        assertEquals(expected, change.room)
    }
}