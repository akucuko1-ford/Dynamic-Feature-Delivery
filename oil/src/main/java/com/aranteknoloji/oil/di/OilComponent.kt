package com.aranteknoloji.oil.di

import com.aranteknoloji.feature_common.OilFeature
import com.aranteknoloji.oil.OilFeatureImpl
import com.aranteknoloji.oil.OilLifeComponent
import com.aranteknoloji.oil.views.di.OilLifeActivityComponent
import dagger.BindsInstance
import dagger.Component

@OilScope
@Component(
    modules = [OilModule::class, OilBinders::class],
    dependencies = [OilFeature.Dependencies::class]
)
interface OilComponent {
    val oilLifeComponent: OilLifeComponent
    val oilLifeActivityComponentFactory: OilLifeActivityComponent.Factory

    fun inject(oilFeature: OilFeatureImpl)

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: OilFeature.Dependencies,
            @BindsInstance oilFeature: OilFeatureImpl
        ): OilComponent
    }
}