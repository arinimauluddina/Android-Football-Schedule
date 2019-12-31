package com.example.hp.footballmatchschedule.activity.base

import io.reactivex.disposables.CompositeDisposable


open class BasePresenter <T: BaseView>{

    protected var compositeDisposable = CompositeDisposable()
    protected var mView: T? = null

    fun onAttach(view: T){
        this.mView = view
    }

    fun onDettach(){
        this.mView = null
    }

}