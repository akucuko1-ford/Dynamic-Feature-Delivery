package com.aranteknoloji.dynamicfeaturetraining.utils

import com.aranteknoloji.feature_common.base.BaseComponent
import com.aranteknoloji.feature_common.FeatureTypes

infix fun <K, V> MutableMap<K, V>.put(pair: Pair<K, V>) {
    put(pair.first, pair.second)
}

/**
 * Returns non-nullable BaseComponent from the the map
 *
 * @return BaseComponent from the the map
 *
 * @throws Exception if the map does not have the component
 *
 * @see BaseComponent
 * @see Exception
 * */
fun MutableMap<FeatureTypes, BaseComponent>.getNonNull(featureType: FeatureTypes): BaseComponent =
    this[featureType]
        ?: throw Exception("$featureType component needs to be added to the adapter before its usage")

/**
 * Returns given integer's FeatureTypes if it is exists in the FeatureTypes,
 * otherwise throws Exception
 *
 * @return FeatureType
 *
 * @see FeatureTypes
 * @see Exception
 * */
fun getViewType(type: Int): FeatureTypes =
    FeatureTypes.values().firstOrNull { it.type == type }
        ?: throw Exception("$type is not supported")