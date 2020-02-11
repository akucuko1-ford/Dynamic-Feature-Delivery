package com.aranteknoloji.dynamicfeaturetraining.adapters

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.aranteknoloji.dynamicfeaturetraining.utils.getNonNull
import com.aranteknoloji.dynamicfeaturetraining.utils.getViewType
import com.aranteknoloji.dynamicfeaturetraining.utils.put
import com.aranteknoloji.feature_common.BaseComponent
import com.aranteknoloji.feature_common.FeatureTypes
import javax.inject.Inject

class MainViewAdapter @Inject constructor() :
    RecyclerView.Adapter<MainViewAdapter.MainViewHolder>() {

    private var data: MutableList<Pair<FeatureTypes, BaseComponent>> = mutableListOf()
    private val items: MutableMap<FeatureTypes, BaseComponent> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(items.getNonNull(getViewType(viewType)).holderView(parent))

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        data[position].second.updateComponent(holder.view)
    }

    override fun getItemViewType(position: Int): Int =
        data[position].first.type

    fun setData(data: MutableList<Pair<FeatureTypes, BaseComponent>>) {
        items.clear()
        this.data = data
        data.forEach { items put it }
        notifyDataSetChanged()
    }

    inner class MainViewHolder(val view: ViewDataBinding) : RecyclerView.ViewHolder(view.root)
}