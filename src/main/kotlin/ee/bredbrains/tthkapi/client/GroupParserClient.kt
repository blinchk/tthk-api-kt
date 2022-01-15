package ee.bredbrains.tthkapi.client

import ee.bredbrains.tthkapi.model.Group
import ee.bredbrains.tthkapi.model.ParsableUrls
import org.jsoup.select.Elements

class GroupParserClient : ParserClient<Group>() {
    override fun parse(urls: ParsableUrls): Collection<Group> {
        val firstUrl = urls.values.first()
        return parse(firstUrl)
    }

    override fun processCells(cells: Elements): Group? {
        val parts = cells.eachText().toTypedArray()
        return Group.Factory.fromList(parts)
    }

}