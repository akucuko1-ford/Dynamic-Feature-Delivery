package com.aranteknoloji.dynamicfeaturetraining.di

import androidx.lifecycle.ViewModel
import com.aranteknoloji.dynamicfeaturetraining.viewmodels.MainActivityViewModel
import com.aranteknoloji.feature_common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBinders {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindsMainActivityViewModelIntoMap(mainActivityViewModel: MainActivityViewModel): ViewModel
}