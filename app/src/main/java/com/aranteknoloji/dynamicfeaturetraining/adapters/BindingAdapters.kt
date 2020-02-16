package com.aranteknoloji.dynamicfeaturetraining.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("decoration")
fun setDecoration(view: RecyclerView, decoration: RecyclerView.ItemDecoration) {
    view.addItemDecoration(decoration)
}

@BindingAdapter("touchAdapter")
fun addItemTouchAdapter(view: RecyclerView, adapter: ItemTouchAdapter) {
    ItemTouchHelper(adapter).attachToRecyclerView(view)
}