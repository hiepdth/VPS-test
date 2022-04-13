package com.hiepdt.vpstest.bottomsheet

import com.hiepdt.vpstest.R
import com.hiepdt.vpstest.base.BasePresenter
import com.hiepdt.vpstest.models.ServiceItemModel

class ServicePresenterImpl<V : ServiceView> : BasePresenter<V>(), ServicePresenter<V> {
    override fun getServiceList() {
        val model = dataManager.serviceList
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
        mvpView?.onGetServiceListSuccess(model)
    }

    override fun updateServiceListToSharePref(dataList: List<ServiceItemModel>?) {
        if (dataList == null || dataList.isEmpty()) return

        //Todo: Lưu lại danh sách vào SharePreference
        dataManager.serviceList = dataList
    }
}