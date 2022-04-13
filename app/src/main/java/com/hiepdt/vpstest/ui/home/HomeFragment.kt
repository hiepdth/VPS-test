package com.hiepdt.vpstest.ui.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hiepdt.vpstest.R
import com.hiepdt.vpstest.base.BaseFragment
import com.hiepdt.vpstest.bottomsheet.ServiceBottomSheet
import com.hiepdt.vpstest.models.RegisterServiceModel
import com.hiepdt.vpstest.models.ServiceItemModel
import com.hiepdt.vpstest.models.SpecialFeatureModel
import kotlinx.android.synthetic.main.frm_home.*

class HomeFragment : BaseFragment(), ServiceAdapter.OnServiceItemListener, HomeView {

    private var serviceAdapter: ServiceAdapter? = null
    private var featureAdapter: SpecialFeatureAdapter? = null
    private var registerAdapter: RegisterServiceAdapter? = null

    private val presenter by lazy {
        HomePresenterImpl<HomeView>()
    }

    companion object {
        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frm_home, container, false)
    }

    override fun setUp(view: View?) {
        presenter.onAttach(this)
        presenter.getServiceList()
        presenter.getFeatureList()
        presenter.getRegisterServiceList()

        initViews()
        initActions()
    }

    private fun initViews() {
    }

    private fun initActions() {
    }

    override fun onServiceItemClick(position: Int, model: ServiceItemModel?) {
        if (model?.serviceId == null || model.serviceId != -1) {
            showMessage("Tính năng đang phát triển")
            return
        }

        val bottomSheet = ServiceBottomSheet { isChange ->
            //Todo: Kiểm tra nếu có sự thay đổi gọi lại danh sách dịch vụ
            if (isChange) {
                showLoading()
                Handler().postDelayed({
                    hideLoading()
                    presenter.getServiceList()
                }, 1500)
            }
        }
        bottomSheet.show(childFragmentManager, "SERVICE_BOTTOM_SHEET")
    }

    override fun onItemMoved(dataList: List<ServiceItemModel>?) {
        //Todo:
    }

    override fun onGetServiceListSuccess(models: List<ServiceItemModel>?) {
        serviceAdapter = ServiceAdapter(context, models, this)
        rcvServices?.adapter = serviceAdapter
    }

    override fun onGetFeatureListSuccess(models: List<SpecialFeatureModel>?) {
        featureAdapter = SpecialFeatureAdapter(context, models)
        rcvFeature?.adapter = featureAdapter
    }

    override fun onGetRegisterServiceListSuccess(models: List<RegisterServiceModel>?) {
        registerAdapter = RegisterServiceAdapter(context, models)
        rcvRegister?.adapter = registerAdapter
    }
}
