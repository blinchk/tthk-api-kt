package ee.bredbrains.tthkapi.client

import ee.bredbrains.tthkapi.model.Change
import ee.bredbrains.tthkapi.model.ParsableUrls
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class ChangeParserClient : ParserClient<Change>() {
    override fun parse(urls: ParsableUrls): List<Change> {
        val firstUrl = urls.values.first()
        return parse(firstUrl)
    }

    fun parse(url: String): List<Change> {
        val document: Document = Jsoup.connect(url).get()
        val tables = parseTables(document)
        return processTables(tables)
    }

    private fun processTables(tables: Elements): List<Change> {
        val changes = ArrayList<Change>()
        tables.forEach {changes.addAll(processRows(parseTableRows(it))) }
        return changes
    }

    private fun processRows(rows: Elements): List<Change> {
        val changes = ArrayList<Change>()
        rows.forEach { processCells(parseTableCells(it))?.let { it1 -> changes.add(it1) } }
        return changes
    }

    private fun processCells(cells: Elements): Change? {
        val parts = cells.eachText().toTypedArray()
        return Change.Factory.fromList(parts)
    }
}