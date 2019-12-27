package com.example.hp.footballmatchschedule.activity.detail

import com.example.hp.footballmatchschedule.activity.base.BaseView
import com.example.hp.footballmatchschedule.model.Teams

interface DetailView : BaseView{

    fun displayTeamBadgeHome(team : Teams)
    fun displayTeamBadgeAway(team: Teams)

}