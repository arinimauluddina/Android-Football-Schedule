package com.example.hp.footballmatchschedule.Activity.detail

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import com.example.hp.footballmatchschedule.Model.MatchEventPresenter

class DetailPresenter(val mView : DetailView.View, val matchEventPresenter: MatchEventPresenter) : DetailView.Presenter {
    override fun getTeamsBadgeAway(id: String) {
        compositeDisposable.add(matchEventPresenter.getTeams(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                mView.displayTeamBadgeHome(it.teams[0])
            })
    }

    val compositeDisposable = CompositeDisposable()

    override fun getTeamsBadgeHome(id: String) {
        compositeDisposable.add(matchEventPresenter.getTeams(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                mView.displayTeamBadgeHome(it.teams[0])
            })
    }
}