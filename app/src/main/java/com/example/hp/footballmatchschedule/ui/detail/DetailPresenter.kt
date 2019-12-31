package com.example.hp.footballmatchschedule.activity.detail

import com.example.hp.footballmatchschedule.activity.base.BasePresenter
import com.example.hp.footballmatchschedule.data.repository.MatchEventRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailPresenter(val matchEventRepository: MatchEventRepository) : BasePresenter<DetailView>() {

    fun getTeamsBadgeAway(id: String) {
        compositeDisposable.add(matchEventRepository.getTeams(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                mView?.displayTeamBadgeAway(it.teams[0])
            })
    }

    fun getTeamsBadgeHome(id: String) {
        compositeDisposable.add(matchEventRepository.getTeams(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                mView?.displayTeamBadgeHome(it.teams[0])
            })
    }
}