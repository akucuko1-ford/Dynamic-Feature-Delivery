package com.aranteknoloji.oil.viewmodels

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.aranteknoloji.oil.data.OilLifeApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ComponentOilLifeViewModel @Inject constructor(oilLifeApi: OilLifeApi) : ViewModel() {

    val oilLifePercentage: ObservableField<String> = ObservableField("")

    private val disposables = CompositeDisposable()

    init {
        disposables.add(
            oilLifeApi.getOilLifeInfo()
                .mergeUntilCompletes(getIntervalObs())
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { oilLifePercentage.set(it) }
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
        println("onCleared has been called")
        Log.i("ViewModel", "onCleared has been called")
    }

    private fun getIntervalObs(): Observable<String> {
        val loadings = listOf("Loading", "Loading.", "Loading..", "Loading...")
        return Observable.interval(0, 500, TimeUnit.MILLISECONDS)
            .map { loadings[it.toInt() % 4] }
    }
}

fun <T> Observable<T>.mergeUntilCompletes(source2: Observable<T>): Observable<T> =
    Observable.merge(this, source2.takeUntil(this))