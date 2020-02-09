package com.aranteknoloji.feature_common

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

interface BaseComponent {

    /**
     * This method would be called when the component needs to be updated
     *
     * @param view is to set DataBinding for the component
     *
     * For example; setting setOnClickListener{...} or ViewModel to your binding
     *
     * */
    fun updateComponent(view: ViewDataBinding)

    /**
     * This method needs to set the Data Binding object for the component
     *
     * @param parent is for getting the inflater and initiate the layout
     *
     * @see ViewDataBinding
     * */
    fun holderView(parent: ViewGroup): ViewDataBinding
}