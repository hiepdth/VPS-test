package com.hiepdt.vpstest.ui.home

import com.hiepdt.vpstest.R
import com.hiepdt.vpstest.base.BasePresenter
import com.hiepdt.vpstest.models.RegisterServiceModel
import com.hiepdt.vpstest.models.ServiceItemModel
import com.hiepdt.vpstest.models.SpecialFeatureModel

class HomePresenterImpl<V : HomeView> : BasePresenter<V>(), HomePresenter<V> {
    override fun getServiceList() {
        var model = dataManager.serviceList     //Todo: Lấy danh sách service từ SharePreference
        if (model == null || model.isEmpty()) {
            model.add(ServiceItemModel(1, R.drawable.ic_stock, "Cổ phiếu"))
            model.add(ServiceItemModel(2, R.drawable.ic_derivative, "Phái sinh"))
            model.add(ServiceItemModel(3, R.drawable.ic_money_market, "Money\nMarket"))
            model.add(ServiceItemModel(4, R.drawable.ic_bonds, "Trái phiếu"))
            model.add(ServiceItemModel(5, R.drawable.ic_wallet, "Thanh toán"))
            model.add(ServiceItemModel(6, R.drawable.ic_insurance, "Bảo hiểm"))
            model.add(ServiceItemModel(7, R.drawable.ic_transaction, "Giao dịch\ntiền"))
            model.add(ServiceItemModel(8, R.drawable.ic_cookie, "Vcookie"))
            model.add(ServiceItemModel(9, R.drawable.ic_manage_categories, "Quản lý\ndanh mục"))
            model.add(ServiceItemModel(10, R.drawable.ic_money_card, "Tiền gửi\ntại NHTM"))
        }
        //Todo: Sublist lấy 7 phần tử đầu tiên
        model = if (model?.size!! > 7) model.subList(0, 7) else model
        model.add(ServiceItemModel(-1, R.drawable.ic_see_more, "Xem thêm"))
        mvpView?.onGetServiceListSuccess(model)
    }

    override fun getFeatureList() {
        val featureList = ArrayList<SpecialFeatureModel>()
        featureList.add(SpecialFeatureModel(1, R.drawable.ic_qr_code, R.drawable.bg_special_feature_1, "Smart QR"))
        featureList.add(SpecialFeatureModel(2, R.drawable.ic_investment_recomendation, R.drawable.bg_special_feature_2, "Khuyến nghị\nđầu tư"))
        featureList.add(SpecialFeatureModel(3, R.drawable.ic_analytics, R.drawable.bg_special_feature_3, "Thị trường"))
        featureList.add(SpecialFeatureModel(4, R.drawable.ic_analytics, R.drawable.bg_special_feature_3, "Chứng khoán"))

        mvpView?.onGetFeatureListSuccess(featureList)
    }

    override fun getRegisterServiceList() {
        val registerList = ArrayList<RegisterServiceModel>()
        registerList.add(RegisterServiceModel(1, R.drawable.ic_chart, "Dịch vụ\nChứng khoán"))
        registerList.add(RegisterServiceModel(2, R.drawable.ic_finance_product, "Dịch vụ\nSP tài chính"))
        registerList.add(RegisterServiceModel(3, R.drawable.ic_link_service, "Dịch vụ\nLiên kết"))
        registerList.add(RegisterServiceModel(4, R.drawable.ic_account_service, "Dịch vụ\nTài khoản"))

        mvpView?.onGetRegisterServiceListSuccess(registerList)
    }
}