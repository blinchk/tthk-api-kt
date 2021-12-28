package ee.bredbrains.tthkapi.util

import ee.bredbrains.tthkapi.model.ChangeStatus
import java.util.regex.Pattern

object ChangeUtil {
    private val statusTriggers = mapOf(
        "lõuna" to ChangeStatus.LUNCH,
        "söögivahetund" to ChangeStatus.LUNCH,
        "jääb ära" to ChangeStatus.DROPPED_OUT,
        "iseseisev ülesanne kodus" to ChangeStatus.HOMEWORK,
        "iseseisev ülesanne kodus(vt tahvel)" to ChangeStatus.HOMEWORK,
        "iseseisev ülesanne kodus(vt tahvlis)" to ChangeStatus.HOMEWORK,
        "iseseisev töö kodus" to ChangeStatus.HOMEWORK,
        "tunnid toimuvad" to ChangeStatus.SCHEDULED,
    )

    fun determineStatus(status: String): ChangeStatus {
        val statusByDefault = ChangeStatus.DROPPED_OUT
        val key = statusTriggers.keys.first { status.lowercase().contains(it) }
        return statusTriggers.getOrDefault(key, statusByDefault)
    }

    fun isStatus(status: String): Boolean {
        return statusTriggers.keys.any { status.lowercase().contains(it) }
    }

    const val CHANGES_URL = "https://www.tthk.ee/tunniplaani-muudatused/"
}