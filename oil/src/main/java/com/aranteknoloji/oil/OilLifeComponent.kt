package com.aranteknoloji.oil

import android.content.Intent
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.aranteknoloji.feature_common.viewmodel.ViewModelFactory
import com.aranteknoloji.feature_common.base.BaseActivity
import com.aranteknoloji.feature_common.base.BaseComponent
import com.aranteknoloji.oil.databinding.ComponentOilBinding
import com.aranteknoloji.oil.di.OilScope
import com.aranteknoloji.oil.viewmodels.ComponentOilLifeViewModel
import com.aranteknoloji.oil.views.OilLifeActivity
import javax.inject.Inject

@OilScope
class OilLifeComponent @Inject constructor(
    private val activity: BaseActivity,
    private val viewModelFactory: ViewModelFactory
) : BaseComponent {

    override fun updateComponent(view: ViewDataBinding) {
        val viewModel =
            ViewModelProvider(activity, viewModelFactory).get(ComponentOilLifeViewModel::class.java)
        val binding = view as ComponentOilBinding
        binding.viewModel = viewModel
        binding.root.setOnClickListener {
            it.context.apply {
                startActivity(Intent(this, OilLifeActivity::class.java))
            }
        }
        binding.executePendingBindings()
    }

    override fun holderView(parent: ViewGroup): ViewDataBinding {
        val inflater = activity.layoutInflater
        return ComponentOilBinding.inflate(inflater)
    }
}