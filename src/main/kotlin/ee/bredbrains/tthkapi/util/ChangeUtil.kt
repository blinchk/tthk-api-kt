package ee.bredbrains.tthkapi.util

import ee.bredbrains.tthkapi.model.ChangeStatus

object ChangeUtil {
    private val statusTriggers = mapOf(
        "lõuna" to ChangeStatus.LUNCH,
        "söögivahetund" to ChangeStatus.LUNCH,
        "jääb ära" to ChangeStatus.DROPPED_OUT,
        "iseseisev ülesanne kodus" to ChangeStatus.HOMEWORK,
        "iseseisev töö kodus" to ChangeStatus.HOMEWORK,
        "tunnid toimuvad" to ChangeStatus.SCHEDULED,
    )

    fun determineStatus(status: String) = statusTriggers.getOrDefault(status.lowercase(), ChangeStatus.DROPPED_OUT)

    fun isStatus(status: String) = statusTriggers.containsKey(status.lowercase())
}