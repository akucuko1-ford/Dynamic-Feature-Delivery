package com.aranteknoloji.dynamicfeaturetraining.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("decoration")
fun setDecoration(view: RecyclerView, decoration: RecyclerView.ItemDecoration) {
    view.addItemDecoration(decoration)
}