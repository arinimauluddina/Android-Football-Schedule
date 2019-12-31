package com.example.hp.footballmatchschedule.activity.main

import com.example.hp.footballmatchschedule.model.MatchEvent
import com.example.hp.footballmatchschedule.activity.base.BaseView

interface MainView : BaseView{
    fun hideLoading()
    fun showLoading()
    fun displayFootballMatch(matchList:List<MatchEvent>)
}