package com.aranteknoloji.feature_common

import android.content.Context
import android.content.Intent
import com.aranteknoloji.feature_common.base.BaseActivity
import com.aranteknoloji.feature_common.base.BaseComponent

interface Feature<T> {
    fun getFeatureComponent(): BaseComponent
    fun launcherIntent(context: Context): Intent
    fun inject(dependencies: T)

    interface Dependencies {
        val activity: BaseActivity
    }
}

interface OilFeature : Feature<OilFeature.Dependencies> {
    interface Dependencies : Feature.Dependencies
}