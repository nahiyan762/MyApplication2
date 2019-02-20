package android.com.myapplication.model

class GiftList {
    private var gift: String? = null

    private var id: String? = null

    fun getGift(): String? {
        return gift
    }

    fun setGift(gift: String) {
        this.gift = gift
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }
}