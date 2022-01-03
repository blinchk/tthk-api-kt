package ee.bredbrains.tthkapi.model

class ParsableUrls() : HashMap<Department?, String>() {
    constructor(department: Department?, url: String) : this() {
        this[department] = url
    }

    constructor(vararg pair: Pair<Department, String>) : this() {
        this.putAll(pair)
    }

    val departments get() = keys
    val urls get() = values
}

