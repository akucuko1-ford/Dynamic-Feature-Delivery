package com.aranteknoloji.oil

import android.content.Context
import android.content.Intent
import com.aranteknoloji.feature_common.BaseComponent
import com.aranteknoloji.feature_common.OilFeature
import com.aranteknoloji.oil.di.DaggerOilComponent
import com.aranteknoloji.oil.di.OilComponent
import com.aranteknoloji.oil.views.OilLifeActivity
import com.google.auto.service.AutoService

lateinit var oilComponent: OilComponent
    private set

@AutoService(OilFeature::class)
class OilFeatureImpl : OilFeature {

    override fun getFeatureComponent(): BaseComponent =
        OilLifeComponent(oilComponent.activity)

    override fun launcherIntent(context: Context): Intent =
        Intent(context, OilLifeActivity::class.java)

    override fun inject(dependencies: OilFeature.Dependencies) {
        if (::oilComponent.isInitialized) return

        oilComponent = DaggerOilComponent.factory()
            .create(dependencies, this)
    }
}