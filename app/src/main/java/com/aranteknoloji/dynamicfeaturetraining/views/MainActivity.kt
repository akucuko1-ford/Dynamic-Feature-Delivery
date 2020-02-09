package com.aranteknoloji.dynamicfeaturetraining.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aranteknoloji.dynamicfeaturetraining.R
import com.aranteknoloji.dynamicfeaturetraining.ViewModelFactory
import com.aranteknoloji.dynamicfeaturetraining.viewmodels.MainActivityViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainActivityViewModel::class.java)
        viewModel.init(main_view)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
