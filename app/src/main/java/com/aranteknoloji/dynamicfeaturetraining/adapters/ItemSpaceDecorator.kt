package com.aranteknoloji.dynamicfeaturetraining.adapters

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemSpaceDecorator(private val verticalSpaceHeight: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = verticalSpaceHeight
        outRect.left = verticalSpaceHeight
        outRect.top = verticalSpaceHeight
        if (parent.getChildAdapterPosition(view) == parent.adapter?.itemCount?.minus(1))
            outRect.bottom = verticalSpaceHeight
    }
}