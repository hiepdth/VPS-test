package com.hiepdt.vpstest.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiepdt.vpstest.R
import com.hiepdt.vpstest.models.ServiceItemModel
import kotlinx.android.synthetic.main.item_service.view.*
import java.util.*

class ServiceAdapter(
        private val context: Context?,
        private val dataList: List<ServiceItemModel>?,
        private var listener: OnServiceItemListener?
) : RecyclerView.Adapter<ServiceAdapter.MyHolder>(), ItemMoveCallback.ItemTouchHelperContract {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.item_service, parent, false)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(dataList?.get(position))
        holder.itemView.setOnClickListener {
            listener?.onServiceItemClick(position, dataList?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: ServiceItemModel?) {
            itemView.apply {
                model?.icon?.let { imgIcon?.setImageResource(it) }
                tvServiceName?.text = model?.serviceName ?: ""
            }
        }
    }

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        //Todo: Xử lý logic sau khi drag&drop
        if (dataList == null || dataList.isEmpty()) return
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(dataList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(dataList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        listener?.onItemMoved(dataList)
    }

    interface OnServiceItemListener {
        fun onServiceItemClick(position: Int, model: ServiceItemModel?)
        fun onItemMoved(dataList: List<ServiceItemModel>?)
    }
}