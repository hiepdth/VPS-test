package com.hiepdt.vpstest.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import com.hiepdt.vpstest.R
import com.hiepdt.vpstest.base.BaseBottomSheet
import com.hiepdt.vpstest.models.ServiceItemModel
import com.hiepdt.vpstest.ui.home.ItemMoveCallback
import com.hiepdt.vpstest.ui.home.ServiceAdapter
import kotlinx.android.synthetic.main.frm_services_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_header_bottom_sheet.*

class ServiceBottomSheet(
        private val onChange: (isChange: Boolean) -> Unit
) : BaseBottomSheet(), ServiceView, ServiceAdapter.OnServiceItemListener {
    private var isChange = false
    private var dataList: List<ServiceItemModel>? = null
    private var serviceAdapter: ServiceAdapter? = null
    private val presenter by lazy {
        ServicePresenterImpl<ServiceView>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
        presenter.onAttach(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.frm_services_bottom_sheet
    }

    override fun setUp(view: View?) {
        presenter.getServiceList()
    }

    override fun setOnClickView() {
        tvEdit?.setOnClickListener {
            presenter.updateServiceListToSharePref(dataList)
            onChange.invoke(isChange)
            dismiss()
        }

        imgCancel?.setOnClickListener {
            dismiss()
        }
    }

    override fun onGetServiceListSuccess(models: List<ServiceItemModel>?) {
        serviceAdapter = context?.let { ServiceAdapter(it, models, this) }
        //Todo: Xử lý kéo thả cho adapter
        serviceAdapter?.let {
            val callback: ItemTouchHelper.Callback = ItemMoveCallback(serviceAdapter)
            val touchHelper = ItemTouchHelper(callback)
            touchHelper.attachToRecyclerView(rcvServices)
        }
        rcvServices?.adapter = serviceAdapter
    }

    override fun onServiceItemClick(position: Int, model: ServiceItemModel?) {
    }

    override fun onItemMoved(dataList: List<ServiceItemModel>?) {
        isChange = true
        this.dataList = dataList
    }
}