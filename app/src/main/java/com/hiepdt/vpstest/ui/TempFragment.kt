package com.hiepdt.vpstest.ui

import android.os.Bundle
import android.view.View
import com.hiepdt.vpstest.base.BaseFragment

class TempFragment() : BaseFragment() {
    companion object {
        fun newInstance(): TempFragment {
            val args = Bundle()
            val fragment = TempFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun setUp(view: View?) {

    }
}