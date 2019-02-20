package android.com.myapplication.model

class ProductGroupList {
    private var id: String? = null

    private var product_group: String? = null

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getProduct_group(): String? {
        return product_group
    }

    fun setProduct_group(product_group: String) {
        this.product_group = product_group
    }
}