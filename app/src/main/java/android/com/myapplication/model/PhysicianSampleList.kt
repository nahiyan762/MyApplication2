package android.com.myapplication.model

class PhysicianSampleList {
    private var id: String? = null

    private var sample: String? = null

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getSample(): String? {
        return sample
    }

    fun setSample(sample: String) {
        this.sample = sample
    }
}