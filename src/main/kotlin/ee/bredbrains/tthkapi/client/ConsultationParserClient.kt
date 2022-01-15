package ee.bredbrains.tthkapi.client

import ee.bredbrains.tthkapi.model.Consultation
import ee.bredbrains.tthkapi.model.Department
import ee.bredbrains.tthkapi.model.ParsableUrls
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class ConsultationParserClient : ArgumentParserClient<Consultation, Department>() {
    override fun parse(urls: ParsableUrls): List<Consultation> {
        val consultations = ArrayList<Consultation>()
        urls.forEach { url -> consultations += parse(url.value, url.key!!) }
        return consultations
    }

    private fun parse(url: String, department: Department): List<Consultation> {
        val consultations = ArrayList<Consultation>()
        val document: Document = Jsoup.connect(url).get()
        consultations += processTables(parseTables(document), department)
        return consultations
    }

    private fun processTables(tables: Elements, department: Department): List<Consultation> {
        val consultations = ArrayList<Consultation>()
        tables.forEach { consultations += processRows(parseTableRows(it), department) }
        return consultations
    }

    private fun processRows(rows: Elements, department: Department): List<Consultation> {
        val consultations = ArrayList<Consultation>()
        rows.forEach { consultations += processCells(parseTableCells(it), department) }
        return consultations
    }

    override fun processCells(cells: Elements, arg: Department): List<Consultation> {
        val parts = cells.map { cell -> cell.text() }.toTypedArray()
        return Consultation.Factory.fromList(parts, arg)
    }
}