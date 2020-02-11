package com.aranteknoloji.dynamicfeaturetraining.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.aranteknoloji.dynamicfeaturetraining.adapters.MainViewAdapter
import com.aranteknoloji.dynamicfeaturetraining.views.MainActivity
import com.aranteknoloji.feature_common.Feature
import com.aranteknoloji.feature_common.FeatureTypes
import com.aranteknoloji.feature_common.OilFeature
import java.util.*
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    val adapter: MainViewAdapter,
    oilFeatureDependencies: OilFeature.Dependencies,
    mainActivity: MainActivity
) : ViewModel() {

    init {
        val oilFeature: OilFeature? = getFeature(oilFeatureDependencies)
        oilFeature?.let {
            adapter.setData(mutableListOf(Pair(FeatureTypes.OIL, it.getFeatureComponent())))
        }
        Toast.makeText(mainActivity, "Main Activity context", Toast.LENGTH_LONG).show()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "onCleared has been called on MainActivityViewModel")
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