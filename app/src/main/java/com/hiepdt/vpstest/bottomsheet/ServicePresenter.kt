package com.hiepdt.vpstest.bottomsheet

import com.hiepdt.vpstest.models.ServiceItemModel

interface ServicePresenter <V : ServiceView> {
    fun getServiceList()
    fun updateServiceListToSharePref(dataList: List<ServiceItemModel>?)
}