package ee.bredbrains.tthkapi.client

import ee.bredbrains.tthkapi.model.Consultation
import ee.bredbrains.tthkapi.model.Department
import ee.bredbrains.tthkapi.model.ParsableUrls

class ConsultationParserClient : ParserClient<Consultation>() {
    override fun parse(urls: ParsableUrls): List<Consultation> {
        TODO("Not yet implemented")
    }

    fun parse(url: String, department: Department): List<Consultation> {
        TODO("Not yet implemented")
    }
}