package com.aranteknoloji.dynamicfeaturetraining.di

import android.content.Context
import com.aranteknoloji.dynamicfeaturetraining.MainApplication
import com.aranteknoloji.feature_common.BaseFeatureInfo
import com.aranteknoloji.feature_common.OilFeature
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    @JvmStatic
    fun providesApplicationContext(application: MainApplication): Context = application

    @Provides
    @Reusable
    @JvmStatic
    fun providesOilFeatureDependencies(context: Context): OilFeature.Dependencies =
        object : OilFeature.Dependencies {
            override val context: Context = context
            override val info: BaseFeatureInfo = BaseFeatureInfo("Deneme yag feature i")
        }
}