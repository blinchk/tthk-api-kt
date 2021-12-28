package ee.bredbrains.tthkapi.client

import ee.bredbrains.tthkapi.util.ParserUtil.TABLE_CELL_SELECTOR
import ee.bredbrains.tthkapi.util.ParserUtil.TABLE_ROW_SELECTOR
import ee.bredbrains.tthkapi.util.ParserUtil.TABLE_SELECTOR
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

abstract class ParserClient<T> {
    abstract fun parse(urls: List<String>): List<T>
    fun parseTables(document: Document) = document.select(TABLE_SELECTOR)
    fun parseTableRows(table: Element) = table.select(TABLE_ROW_SELECTOR)
    fun parseTableCells(row: Element) = row.select(TABLE_CELL_SELECTOR)
}