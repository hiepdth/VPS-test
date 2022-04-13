package com.hiepdt.vpstest.bottomsheet

import com.hiepdt.vpstest.base.MvpView
import com.hiepdt.vpstest.models.ServiceItemModel

interface ServiceView : MvpView {
    fun onGetServiceListSuccess(models: List<ServiceItemModel>?)
}