package com.aranteknoloji.dynamicfeaturetraining.di

import com.aranteknoloji.dynamicfeaturetraining.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        ActivityContributor::class,
        ViewModelBinders::class
    ]
)
interface AppComponent {

    fun inject(application: MainApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance mainApplication: MainApplication): AppComponent
    }
}