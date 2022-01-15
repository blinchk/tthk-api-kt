package ee.bredbrains.tthkapi.client

import ee.bredbrains.tthkapi.model.ParsableUrls
import ee.bredbrains.tthkapi.model.UpdatableEntity
import org.jsoup.select.Elements

abstract class ArgumentParserClient<T, A> : ParserClient<T>() where T : UpdatableEntity {
    abstract override fun parse(urls: ParsableUrls): List<T>

    override fun processCells(cells: Elements): T? {
        throw NotImplementedError()
    }

    abstract fun processCells(cells: Elements, arg: A): List<T>
}