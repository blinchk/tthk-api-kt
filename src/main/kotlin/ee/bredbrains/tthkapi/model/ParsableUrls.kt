package ee.bredbrains.tthkapi.model

class ParsableUrls() : HashMap<Department?, String>() {
    constructor(department: Department?, url: String) : this() {
        this[department] = url
    }
}
