package com.aranteknoloji.dynamicfeaturetraining.di

import com.aranteknoloji.dynamicfeaturetraining.views.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityContributor {
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}