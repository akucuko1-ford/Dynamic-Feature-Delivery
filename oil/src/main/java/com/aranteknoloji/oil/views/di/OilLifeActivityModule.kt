package com.aranteknoloji.oil.views.di

import com.aranteknoloji.oil.Den
import dagger.Module
import dagger.Provides

@Module
object OilLifeActivityModule {

    @Provides
    @JvmStatic
    fun provideStrDen(): Den = object : Den {
        override val str: String = "OilLifeActivity has been successfully launched with Dagger"
    }

    @Module
    interface Contributor
}