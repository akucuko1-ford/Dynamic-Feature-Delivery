package com.aranteknoloji.dynamicfeaturetraining.utils

import com.aranteknoloji.feature_common.BaseComponent
import com.aranteknoloji.feature_common.FeatureTypes

infix fun <K, V> MutableMap<K, V>.put(pair: Pair<K, V>) {
    put(pair.first, pair.second)
}

fun MutableMap<FeatureTypes, BaseComponent>.getNonNull(featureType: FeatureTypes): BaseComponent =
    this[featureType]
        ?: throw Exception("$featureType component needs to be added to the adapter before its usage")

fun getViewType(type: Int): FeatureTypes =
    FeatureTypes.values().firstOrNull { it.type == type }
        ?: throw Exception("$type is not supported")