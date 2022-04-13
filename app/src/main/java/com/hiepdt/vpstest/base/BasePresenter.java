package com.hiepdt.vpstest.base;

/**
 * Created by hiepdt on 12/04/2022
 */

public class BasePresenter<V extends MvpView>{

    private static final String TAG = "BasePresenter";

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

}