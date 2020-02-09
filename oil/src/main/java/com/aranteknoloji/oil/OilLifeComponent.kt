package com.aranteknoloji.oil

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.aranteknoloji.feature_common.BaseComponent
import com.aranteknoloji.oil.databinding.ComponentOilBinding
import com.aranteknoloji.oil.viewmodels.ComponentOilLifeViewModel
import com.aranteknoloji.oil.views.OilLifeActivity

class OilLifeComponent: BaseComponent {

    override fun updateComponent(view: ViewDataBinding) {
        val binding = view as ComponentOilBinding
        binding.viewModel = ComponentOilLifeViewModel()
        binding.root.setOnClickListener {
            it.context.apply {
                startActivity(Intent(this, OilLifeActivity::class.java))
            }
        }
        binding.executePendingBindings()
    }

    override fun holderView(parent: ViewGroup): ViewDataBinding {
        val inflater = LayoutInflater.from(parent.context)
        return ComponentOilBinding.inflate(inflater)
    }
}