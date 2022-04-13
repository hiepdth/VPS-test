package com.hiepdt.vpstest.base;

import com.hiepdt.vpstest.GlobalApp;
import com.hiepdt.vpstest.data.AppDataManager;
import com.hiepdt.vpstest.data.DataManager;

/**
 * Created by hiepdt on 12/04/2022
 */

public class BasePresenter<V extends MvpView>{

    private DataManager dataManager;
    private static final String TAG = "BasePresenter";

    public BasePresenter() {
        dataManager = new AppDataManager(GlobalApp.getAppContext());
    }

    private V mMvpView;

    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public void onDetach() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public static String getTAG() {
        return TAG;
    }

    public V getmMvpView() {
        return mMvpView;
    }

    public void setmMvpView(V mMvpView) {
        this.mMvpView = mMvpView;
    }
}