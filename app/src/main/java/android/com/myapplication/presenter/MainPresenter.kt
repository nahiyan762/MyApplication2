package android.com.myapplication.presenter

import android.com.myapplication.model.MyPojo
import android.com.myapplication.api.ApiClient
import android.com.myapplication.view.MainActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import io.reactivex.functions.Consumer

class MainPresenter(val mainActivity: MainActivity, val compositeDisposable: CompositeDisposable) {

    fun getSampleData(){

        val productGroupList: ArrayList<String> = arrayListOf("Choose")
        val literatureList: ArrayList<String> = arrayListOf("Choose")
        val giftList: ArrayList<String> = arrayListOf("Choose")
        val physicianSampleList: ArrayList<String> = arrayListOf("Choose")

        val sampleData: Observable<MyPojo> = ApiClient.getInstance().getSampleData()

        compositeDisposable.add(
            sampleData
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( Consumer { t ->
                    for(item in 0 until t.getProductGroupList()!!.size){
                        productGroupList.add(t.getProductGroupList()!!.get(item).getProduct_group()!!)
                    }

                    for(item in 0 until t.getLiteratureList()!!.size){
                        literatureList.add(t.getLiteratureList()!!.get(item).getLiterature()!!)
                    }

                    for(item in 0 until t.getGiftList()!!.size){
                        giftList.add(t.getGiftList()!!.get(item).getGift()!!)
                    }

                    for(item in 0 until t.getPhysicianSampleList()!!.size){
                        physicianSampleList.add(t.getPhysicianSampleList()!!.get(item).getSample()!!)
                    }

                },
                    Consumer { t -> t.printStackTrace() }
                    , Action { mainActivity.getSpinnerData(productGroupList,literatureList,giftList,physicianSampleList) }

                ))
    }
}