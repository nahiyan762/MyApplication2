package android.com.myapplication.view

import android.com.myapplication.R
import android.com.myapplication.presenter.MainPresenter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.button.MaterialButton
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var compositeDisposable: CompositeDisposable
    private lateinit var spProduct: Spinner
    private lateinit var spGift: Spinner
    private lateinit var spLiterature: Spinner
    private lateinit var spPhysician: Spinner
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        compositeDisposable = CompositeDisposable()

        spProduct = findViewById(R.id.sp_product)
        spGift = findViewById(R.id.sp_gift)
        spLiterature = findViewById(R.id.sp_literature)
        spPhysician  = findViewById(R.id.sp_physician)
        val btnSubmit: MaterialButton = findViewById(R.id.btn_submit)

        presenter = MainPresenter(this@MainActivity, compositeDisposable)
        presenter.getSampleData()

        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        Toast.makeText(applicationContext, "Done", Toast.LENGTH_SHORT).show()
    }

    fun getSpinnerData(productGroupList: ArrayList<String>, literatureList: ArrayList<String>, giftList: ArrayList<String>, physicianSampleList: ArrayList<String>) {

        val productAdapter : ArrayAdapter<String> = ArrayAdapter(applicationContext,R.layout.my_spinner,productGroupList)
        val giftAdapter : ArrayAdapter<String> = ArrayAdapter(applicationContext,R.layout.my_spinner,giftList)
        val literatureAdapter : ArrayAdapter<String> = ArrayAdapter(applicationContext,R.layout.my_spinner,literatureList)
        val physicianAdapter : ArrayAdapter<String> = ArrayAdapter(applicationContext,R.layout.my_spinner,physicianSampleList)

        spProduct.adapter = productAdapter
        spGift.adapter = giftAdapter
        spLiterature.adapter = literatureAdapter
        spPhysician.adapter = physicianAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
