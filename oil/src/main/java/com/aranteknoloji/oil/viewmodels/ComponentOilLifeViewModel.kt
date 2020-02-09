package com.aranteknoloji.oil.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.aranteknoloji.oil.data.OilLifeApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.CompletableSubject
import java.util.concurrent.TimeUnit

class ComponentOilLifeViewModel : ViewModel() {

    val oilLifePercentage: ObservableField<String> = ObservableField("")

    private val loadings = listOf("Loading", "Loading.", "Loading..", "Loading...")
    private val disposables = CompositeDisposable()
    private val oilLifeApi = OilLifeApi()

    init {
        val subject = CompletableSubject.create()
        disposables.add(oilLifeApi.getOilLifeInfo()
            .doOnNext { subject.onComplete() }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { oilLifePercentage.set(it) })

        disposables.add(getIntervalObs()
            .takeUntil(subject.toObservable<Any>())
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { oilLifePercentage.set(it) })
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    private fun getIntervalObs() =
        Observable.interval(0, 500, TimeUnit.MILLISECONDS)
            .map { loadings[it.toInt() % 4] }
}