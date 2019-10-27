package com.verse.weather.util

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

object RxSchedulerUtils {

    fun <T> getTransformer(): Observable.Transformer<T, T> {
        //子线程执行
        return Observable.Transformer { tObservable ->
            tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

}