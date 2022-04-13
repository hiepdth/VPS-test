package com.hiepdt.vpstest.ui.home

import com.hiepdt.vpstest.base.MvpView
import com.hiepdt.vpstest.models.RegisterServiceModel
import com.hiepdt.vpstest.models.ServiceItemModel
import com.hiepdt.vpstest.models.SpecialFeatureModel

/**
 * Created by hiepdt on 12/04/2022
 */

interface HomeView : MvpView {
    fun onGetServiceListSuccess(models: List<ServiceItemModel>?)
    fun onGetFeatureListSuccess(models: List<SpecialFeatureModel>?)
    fun onGetRegisterServiceListSuccess(models: List<RegisterServiceModel>?)
}