package android.com.myapplication.model

class LiteratureList {
    private var literature: String? = null

    private var id: String? = null

    fun getLiterature(): String? {
        return literature
    }

    fun setLiterature(literature: String) {
        this.literature = literature
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }
}