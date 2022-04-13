package com.hiepdt.vpstest.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiepdt.vpstest.R
import com.hiepdt.vpstest.models.RegisterServiceModel
import kotlinx.android.synthetic.main.item_register_service.view.*

class RegisterServiceAdapter(
    private val context: Context?,
    private val dataList: List<RegisterServiceModel>?
) : RecyclerView.Adapter<RegisterServiceAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v: View =
            LayoutInflater.from(context).inflate(R.layout.item_register_service, parent, false)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(dataList?.get(position))
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: RegisterServiceModel?) {
            itemView.apply {
                if (model == null) return
                model.icon?.let { imgIcon?.setImageResource(it) }
                tvServiceName?.text = model.serviceName ?: ""
            }
        }
    }
}