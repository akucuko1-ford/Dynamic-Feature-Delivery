package com.aranteknoloji.oil.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aranteknoloji.oil.Den
import com.aranteknoloji.oil.R
import com.aranteknoloji.oil.oilComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_oil_life.*
import javax.inject.Inject

class OilLifeActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var den: Den

    override fun onCreate(savedInstanceState: Bundle?) {
        oilComponent.oilLifeActivityComponentFactory
            .create(this)
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oil_life)

        oil_life_des.text = den.str
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}