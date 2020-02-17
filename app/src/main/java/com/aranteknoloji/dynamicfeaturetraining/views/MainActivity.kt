package com.aranteknoloji.dynamicfeaturetraining.views

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aranteknoloji.dynamicfeaturetraining.R
import com.aranteknoloji.dynamicfeaturetraining.databinding.ActivityMainBinding
import com.aranteknoloji.dynamicfeaturetraining.viewmodels.MainActivityViewModel
import com.aranteknoloji.feature_common.base.BaseActivity
import com.aranteknoloji.feature_common.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
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
        println("Activity's instance from MainActivity => $this")
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainActivityViewModel::class.java)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        viewModel.setOnSwipeRemove { action ->
            Snackbar.make(binding.mainLayout, R.string.item_removed_text, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.item_removed_action) { action() }
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Activity's instance onDestroy() get called")
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
