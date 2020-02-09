package com.aranteknoloji.dynamicfeaturetraining

import android.app.Application
import com.aranteknoloji.dynamicfeaturetraining.di.AppComponent
import com.aranteknoloji.dynamicfeaturetraining.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

lateinit var appComponent: AppComponent
    private set

class MainApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() =
        dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()
        //component setup
        appComponent = DaggerAppComponent.factory().create(this)
        appComponent.inject(this)
    }
}