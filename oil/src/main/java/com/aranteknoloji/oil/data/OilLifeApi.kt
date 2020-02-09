package com.aranteknoloji.oil.data

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class OilLifeApi {

    fun getOilLifeInfo() : Observable<String> =
        Observable.just("97")
            .delay(5, TimeUnit.SECONDS)
            .map { "$it%" }
}