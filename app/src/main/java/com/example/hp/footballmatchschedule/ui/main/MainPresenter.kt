package com.example.hp.footballmatchschedule.activity.main

import com.example.hp.footballmatchschedule.activity.base.BasePresenter
import com.example.hp.footballmatchschedule.data.repository.MatchEventRepository
import com.example.hp.footballmatchschedule.utils.ID
import com.example.hp.footballmatchschedule.utils.logI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter (val matchEventRepository: MatchEventRepository) : BasePresenter<MainView>(){

    fun getFootballMatchData(){
        mView?.showLoading()
        compositeDisposable.add(matchEventRepository.getFootballMatch(ID)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(){
                logI("msg", it.events.toString())

                mView?.displayFootballMatch(it.events)
                mView?.hideLoading()
            })
    }

    fun getFootballUpcomingData(){
        mView?.showLoading()
        compositeDisposable.add(matchEventRepository.getUpcomingMatch(ID)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(){
                logI("msg", it.events.toString())

                mView?.displayFootballMatch(it.events)
                mView?.hideLoading()
            })
    }

}