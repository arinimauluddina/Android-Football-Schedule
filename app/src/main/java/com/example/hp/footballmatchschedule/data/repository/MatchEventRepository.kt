package com.example.hp.footballmatchschedule.data.repository

import com.example.hp.footballmatchschedule.data.remote.response.MatchEventResponse
import com.example.hp.footballmatchschedule.data.remote.response.TeamsResponse
import io.reactivex.Flowable

interface MatchEventRepository {
    fun getFootballMatch(id :String) : Flowable<MatchEventResponse>

    fun getTeams(id: String = "0") : Flowable<TeamsResponse>

    fun getUpcomingMatch(id: String) : Flowable<MatchEventResponse>
}