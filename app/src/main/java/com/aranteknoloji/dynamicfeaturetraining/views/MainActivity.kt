package com.aranteknoloji.dynamicfeaturetraining.views

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aranteknoloji.feature_common.viewmodel.ViewModelFactory
import com.aranteknoloji.dynamicfeaturetraining.databinding.ActivityMainBinding
import com.aranteknoloji.dynamicfeaturetraining.viewmodels.MainActivityViewModel
import com.aranteknoloji.feature_common.base.BaseActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseActivity(), HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainActivityViewModel::class.java)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        setContentView(binding.root)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
