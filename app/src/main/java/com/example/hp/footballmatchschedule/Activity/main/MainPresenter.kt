package com.example.hp.footballmatchschedule.Activity.main

import com.example.hp.footballmatchschedule.Model.MatchEventPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(val mView : MainView.View, val matchEventPresenter: MatchEventPresenter) : MainView.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getFootballUpcomingData() {
        mView.showLoading()
        compositeDisposable.add(matchEventPresenter.getUpcomingMatch( "4332")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                mView.displayFootballMatch(it.events)
                mView.hideLoading()
            })
    }
    override fun getFootballMatchData(){
        mView.showLoading()
        compositeDisposable.add(matchEventPresenter.getFootballMatch( "4332")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                mView.displayFootballMatch(it.events)
                mView.hideLoading()
            })
    }
}