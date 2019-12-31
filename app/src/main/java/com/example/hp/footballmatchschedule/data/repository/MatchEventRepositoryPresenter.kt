package com.example.hp.footballmatchschedule.data.repository

import com.example.hp.footballmatchschedule.data.remote.ApiService
import com.example.hp.footballmatchschedule.data.remote.response.MatchEventResponse
import com.example.hp.footballmatchschedule.data.remote.response.TeamsResponse
import io.reactivex.Flowable

class MatchEventRepositoryPresenter(val apiService: ApiService?) : MatchEventRepository{

    override fun getUpcomingMatch(id: String): Flowable<MatchEventResponse> = apiService?.getUpcomingMatch(id)!!

    override fun getFootballMatch(id: String): Flowable<MatchEventResponse> = apiService?.getLastmatch(id)!!

    override fun getTeams(id: String): Flowable<TeamsResponse> = apiService?.getTeam(id)!!
}