package com.example.hp.footballmatchschedule.Activity.detail

import com.example.hp.footballmatchschedule.Model.Teams
import java.util.*

interface DetailView {

    interface View{
        fun displayTeamBadgeHome(team : Teams)
        fun displayTeamBadgeAway(team: Teams)
    }

    interface Presenter{

        fun getTeamsBadgeAway(id :String)
        fun getTeamsBadgeHome(id: String)
    }
}