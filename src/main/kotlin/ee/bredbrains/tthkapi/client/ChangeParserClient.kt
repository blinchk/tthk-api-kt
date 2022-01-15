package ee.bredbrains.tthkapi.client

import ee.bredbrains.tthkapi.model.Change
import ee.bredbrains.tthkapi.model.ParsableUrls
import org.jsoup.select.Elements

class ChangeParserClient : ParserClient<Change>() {
    override fun parse(urls: ParsableUrls): Collection<Change> {
        val firstUrl = urls.values.first()
        return parse(firstUrl)
    }

    override fun processCells(cells: Elements): Change? {
        val parts = cells.eachText().toTypedArray()
        return Change.Factory.fromList(parts)
    }
}