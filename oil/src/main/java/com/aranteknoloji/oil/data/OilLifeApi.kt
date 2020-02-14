package com.aranteknoloji.oil.data

import com.aranteknoloji.oil.di.OilScope
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@OilScope
class OilLifeApi @Inject constructor() {

    fun getOilLifeInfo() : Observable<String> =
        Observable.just("97")
            .delay(5, TimeUnit.SECONDS)
            .map { "$it%" }
}