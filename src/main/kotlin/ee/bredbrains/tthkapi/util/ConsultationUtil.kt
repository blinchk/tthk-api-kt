package ee.bredbrains.tthkapi.util

import ee.bredbrains.tthkapi.model.Department

object ConsultationUtil {
    val CONSULTATION_URLS = mapOf<Department?, String>(
        Department.GENERAL_SUBJECTS to "https://www.tthk.ee/oppetoo/opetajate-konsultatsioonid/uldainete-konsultatsioonid/",
        Department.TRANSPORT to "https://www.tthk.ee/oppetoo/opetajate-konsultatsioonid/transporditehnika-valdkonna-konsultatsioonid/",
        Department.MECHANICS to "https://www.tthk.ee/oppetoo/opetajate-konsultatsioonid/mehaanika-ja-metallitootluse-valdkonna-konsultatsioonid/",
        Department.ENERGY to "https://www.tthk.ee/oppetoo/opetajate-konsultatsioonid/mehhatroonka-osakonna-konsultatsiooid/",
        Department.INFORMATION_TECHNOLOGY to "https://www.tthk.ee/infotehnoloogia-valdkonna-konsultatsioonid/",
        Department.LOGISTICS to "https://www.tthk.ee/logistika-valdkonna-konsultatsioonid/",
        Department.TEXTILE_AND_SALES to "https://www.tthk.ee/oppetoo/opetajate-konsultatsioonid/transporditehnika-valdkonna-konsultatsioonid/",
    )
}