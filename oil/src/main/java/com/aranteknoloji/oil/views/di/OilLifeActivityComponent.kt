package com.aranteknoloji.oil.views.di

import com.aranteknoloji.oil.views.OilLifeActivity
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@OilLifeActivityScope
@Subcomponent(
    modules = [
        OilLifeActivityModule::class,
        OilLifeActivityModule.Contributor::class,
        AndroidInjectionModule::class
    ]
)
interface OilLifeActivityComponent : AndroidInjector<OilLifeActivity> {
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance oilLifeActivity: OilLifeActivity): OilLifeActivityComponent
    }
}