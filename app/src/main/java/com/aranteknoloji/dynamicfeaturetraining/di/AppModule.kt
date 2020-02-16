package com.aranteknoloji.dynamicfeaturetraining.di

import android.content.Context
import com.aranteknoloji.dynamicfeaturetraining.MainApplication
import com.aranteknoloji.dynamicfeaturetraining.adapters.ItemSpaceDecorator
import com.aranteknoloji.dynamicfeaturetraining.adapters.ItemTouchAdapter
import com.aranteknoloji.dynamicfeaturetraining.adapters.MainViewAdapter
import com.aranteknoloji.dynamicfeaturetraining.views.MainActivity
import com.aranteknoloji.feature_common.base.BaseActivity
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
    fun providesOilFeatureDependencies(mainActivity: MainActivity): OilFeature.Dependencies =
        object : OilFeature.Dependencies {
            override val activity: BaseActivity = mainActivity
        }

    @Provides
    @Reusable
    @JvmStatic
    fun providesItemSpaceDecorator(): ItemSpaceDecorator = ItemSpaceDecorator(5)

    @Provides
    @Reusable
    @JvmStatic
    fun providesItemTouchAdapter(adapter: MainViewAdapter): ItemTouchAdapter =
        ItemTouchAdapter(adapter)
}