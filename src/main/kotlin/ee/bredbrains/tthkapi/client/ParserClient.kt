package ee.bredbrains.tthkapi.client

import ee.bredbrains.tthkapi.model.ParsableUrls
import ee.bredbrains.tthkapi.model.UpdatableEntity
import ee.bredbrains.tthkapi.util.ParserUtil.TABLE_CELL_SELECTOR
import ee.bredbrains.tthkapi.util.ParserUtil.TABLE_ROW_SELECTOR
import ee.bredbrains.tthkapi.util.ParserUtil.TABLE_SELECTOR
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

abstract class ParserClient<T> where T : UpdatableEntity {
    abstract fun parse(urls: ParsableUrls): Collection<T>
    fun parseTables(document: Document) = document.select(TABLE_SELECTOR)
    fun parseTableRows(table: Element) = table.select(TABLE_ROW_SELECTOR)
    fun parseTableCells(row: Element) = row.select(TABLE_CELL_SELECTOR)

    open fun parse(url: String): Collection<T> {
        val document: Document = Jsoup.connect(url).get()
        val tables = parseTables(document)
        return processTables(tables)
    }

    open fun processTables(tables: Elements): Collection<T> {
        val entities = ArrayList<T>()
        tables.forEach { entities.addAll(processRows(parseTableRows(it))) }
        return entities
    }

    open fun processRows(rows: Elements): Collection<T> {
        val entities = ArrayList<T>()
        rows.forEach { processCells(parseTableCells(it))?.let { entity -> entities.add(entity) } }
        return entities
    }

    abstract fun processCells(cells: Elements): T?
}