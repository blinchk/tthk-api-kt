package ee.bredbrains.tthkapi.client

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

import ee.bredbrains.tthkapi.util.ParserUtil.TABLE_CELL_SELECTOR
import ee.bredbrains.tthkapi.util.ParserUtil.TABLE_ROW_SELECTOR
import ee.bredbrains.tthkapi.util.ParserUtil.TABLE_SELECTOR
import org.jsoup.select.Elements

interface ParserClient<T> {
    fun parse(url: String): List<T>
    fun parseTables(document: Document): Elements = document.select(TABLE_SELECTOR)
    fun parseTableRows(table: Element): Elements = table.select(TABLE_ROW_SELECTOR)
    fun parseTableCells(row: Element): Elements = row.select(TABLE_CELL_SELECTOR)
}