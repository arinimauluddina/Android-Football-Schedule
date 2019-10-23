package com.example.hp.footballmatchschedule.Activity.main

import com.example.hp.footballmatchschedule.Model.MatchEvent

interface MainView {

    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<MatchEvent>)
    }

    interface Presenter{
        fun getFootballMatchData()

        fun getFootballUpcomingData()
    }
}