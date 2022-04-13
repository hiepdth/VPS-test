package com.hiepdt.vpstest.ui.home

interface HomePresenter<V : HomeView>  {
    fun getServiceList()
    fun getFeatureList()
    fun getRegisterServiceList()
}