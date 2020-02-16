package com.aranteknoloji.dynamicfeaturetraining.adapters

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.aranteknoloji.dynamicfeaturetraining.utils.getNonNull
import com.aranteknoloji.dynamicfeaturetraining.utils.getViewType
import com.aranteknoloji.dynamicfeaturetraining.utils.put
import com.aranteknoloji.feature_common.FeatureTypes
import com.aranteknoloji.feature_common.base.BaseComponent
import dagger.Reusable
import javax.inject.Inject

@Reusable
class MainViewAdapter @Inject constructor() :
    RecyclerView.Adapter<MainViewAdapter.MainViewHolder>(), ItemTouchAdapter.Listener {

    private var data: MutableList<Pair<FeatureTypes, BaseComponent>> = mutableListOf()
    private val items: MutableMap<FeatureTypes, BaseComponent> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(items.getNonNull(getViewType(viewType)).holderView(parent))

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        data[position].second.updateComponent(holder.view)
    }

    override fun onSwipe(position: Int) {
        val item = data.removeAt(position)
        items.remove(item.first)
        notifyItemRemoved(position)
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