package com.aranteknoloji.oil.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aranteknoloji.oil.R
import com.aranteknoloji.oil.oilComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class OilLifeActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        oilComponent.oilLifeActivityComponentFactory
            .create(this)
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oil_life)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}