package android.com.myapplication.model

import com.google.gson.annotations.SerializedName

class MyPojo {

    @SerializedName("gift_list")
    private var giftList: Array<GiftList>? = null

    @SerializedName("product_group_list")
    private var productGroupList: Array<ProductGroupList>? = null

    @SerializedName("literature_list")
    private var literatureList: Array<LiteratureList>? = null

    @SerializedName("physician_sample_list")
    private var physicianSampleList: Array<PhysicianSampleList>? = null

    fun getGiftList(): Array<GiftList>? {
        return giftList
    }

    fun setGiftList(gifList: Array<GiftList>) {
        this.giftList = gifList
    }

    fun getProductGroupList(): Array<ProductGroupList>? {
        return productGroupList
    }

    fun setProducGroupList(productGroupList: Array<ProductGroupList>) {
        this.productGroupList = productGroupList
    }

    fun getLiteratureList(): Array<LiteratureList>? {
        return literatureList
    }

    fun setLiteratureList(literatureList: Array<LiteratureList>) {
        this.literatureList = literatureList
    }

    fun getPhysicianSampleList(): Array<PhysicianSampleList>? {
        return physicianSampleList
    }

    fun setPhysicianSampleList(physicianSampleList: Array<PhysicianSampleList>) {
        this.physicianSampleList = physicianSampleList
    }
}