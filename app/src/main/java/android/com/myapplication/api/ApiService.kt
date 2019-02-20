package android.com.myapplication.api

import android.com.myapplication.model.MyPojo
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("data.json")
    fun getPojoData(): Observable<MyPojo>
}