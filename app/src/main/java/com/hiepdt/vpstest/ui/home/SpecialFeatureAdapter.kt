package com.hiepdt.vpstest.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiepdt.vpstest.R
import com.hiepdt.vpstest.models.SpecialFeatureModel
import kotlinx.android.synthetic.main.item_special_feature.view.*

class SpecialFeatureAdapter(
    private val context: Context,
    private val dataList: ArrayList<SpecialFeatureModel>?
) : RecyclerView.Adapter<SpecialFeatureAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v: View =
            LayoutInflater.from(context).inflate(R.layout.item_special_feature, parent, false)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(dataList?.get(position))
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    fun setData(list: ArrayList<SpecialFeatureModel>?) {
        if (list == null || list.isEmpty()) {
            return
        }
        this.dataList?.clear()
        this.dataList?.addAll(list)
        notifyDataSetChanged()
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: SpecialFeatureModel?) {
            itemView.apply {
                if (model == null) return
                model.background?.let { lnContainer?.setBackgroundResource(it) }
                model.icon?.let { imgIcon?.setImageResource(it) }
                tvFeatureName?.text = model.featureName
            }
        }
    }
}