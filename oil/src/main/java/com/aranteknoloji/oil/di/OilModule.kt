package com.aranteknoloji.oil.di

import androidx.lifecycle.ViewModel
import com.aranteknoloji.dynamicfeaturetraining.di.ViewModelKey
import com.aranteknoloji.oil.viewmodels.ComponentOilLifeViewModel
import com.aranteknoloji.oil.views.di.OilLifeActivityComponent
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(subcomponents = [OilLifeActivityComponent::class])
object OilModule

@Module
abstract class OilBinders {

    @Binds
    @IntoMap
    @ViewModelKey(ComponentOilLifeViewModel::class)
    abstract fun bindsComponentOilLifeViewModel(oilLifeViewModel: ComponentOilLifeViewModel): ViewModel
}