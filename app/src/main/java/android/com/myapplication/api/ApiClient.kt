package android.com.myapplication.api

import android.com.myapplication.model.MyPojo
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    var apiService: ApiService? = null

    constructor(){
        val retrofit = Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    fun getSampleData(): Observable<MyPojo> {
        return apiService!!
            .getPojoData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    companion object {
        var a: ApiClient? = null
        private val GITHUB_BASE_URL = "https://raw.githubusercontent.com/appinion-dev/intern-dcr-data/master/"

        fun getInstance(): ApiClient{
            if(a == null){
                a = ApiClient()
            }
            return this.a!!
        }
    }
}