package com.aranteknoloji.dynamicfeaturetraining.viewmodels

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.aranteknoloji.dynamicfeaturetraining.adapters.MainViewAdapter
import com.aranteknoloji.feature_common.Feature
import com.aranteknoloji.feature_common.FeatureTypes
import com.aranteknoloji.feature_common.OilFeature
import java.util.*
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val adapter: MainViewAdapter,
    private val oilFeatureDependencies: OilFeature.Dependencies
) : ViewModel() {

    fun init(view: RecyclerView) {
        view.adapter = adapter
        val oilFeature: OilFeature? = getFeature(oilFeatureDependencies)
        oilFeature?.let {
            adapter.setData(mutableListOf(Pair(FeatureTypes.OIL, it.getFeatureComponent())))
        }
    }
}

inline fun <reified T : Feature<D>, D> getFeature(dependencies: D): T? {
    val serviceIterator = ServiceLoader.load(
        T::class.java,
        T::class.java.classLoader
    ).iterator()

    return if (serviceIterator.hasNext()) serviceIterator.next().apply { inject(dependencies) }
    else null
}