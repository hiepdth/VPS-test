package com.hiepdt.vpstest.ui.home

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hiepdt.vpstest.R
import com.hiepdt.vpstest.base.BaseActivity
import com.hiepdt.vpstest.models.RegisterServiceModel
import com.hiepdt.vpstest.models.ServiceItemModel
import com.hiepdt.vpstest.models.SpecialFeatureModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private lateinit var serviceAdapter : ServiceAdapter
    private lateinit var featureAdapter : SpecialFeatureAdapter
    private lateinit var registerAdapter : RegisterServiceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_home)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        initViews()
        initActions()
    }

    private fun initViews() {
        val serviceList = ArrayList<ServiceItemModel>()
        serviceList.add(ServiceItemModel(1 , R.drawable.ic_stock, "Cổ phiếu"))
        serviceList.add(ServiceItemModel(2 , R.drawable.ic_stock, "Phái sinh"))
        serviceList.add(ServiceItemModel(3 , R.drawable.ic_stock, "Money market"))
        serviceList.add(ServiceItemModel(4 , R.drawable.ic_stock, "Trái phiếu"))
        serviceAdapter = ServiceAdapter(this, serviceList)
        rcvServices?.adapter = serviceAdapter

        val featureList = ArrayList<SpecialFeatureModel>()
        featureList.add(SpecialFeatureModel(1 , R.drawable.ic_qr_code, R.drawable.ic_special_feature_1, "Smart QR"))
        featureList.add(SpecialFeatureModel(2 , R.drawable.ic_qr_code, R.drawable.ic_special_feature_2, "Smart QR"))
        featureList.add(SpecialFeatureModel(3 , R.drawable.ic_qr_code, R.drawable.ic_special_feature_3, "Smart QR"))
        featureAdapter = SpecialFeatureAdapter(this, featureList)
        rcvFeature?.adapter = featureAdapter


        val registerList = ArrayList<RegisterServiceModel>()
        registerList.add(RegisterServiceModel(1 , R.drawable.ic_chart, "Dịch vụ Chứng khoán"))
        registerList.add(RegisterServiceModel(2 , R.drawable.ic_chart, "Dịch vụ SP tài chính"))
        registerList.add(RegisterServiceModel(3 , R.drawable.ic_chart, "Dịch vụ Liên kết"))
        registerAdapter = RegisterServiceAdapter(this, registerList)
        rcvRegister?.adapter = registerAdapter
    }

    private fun initActions() {

    }
}
