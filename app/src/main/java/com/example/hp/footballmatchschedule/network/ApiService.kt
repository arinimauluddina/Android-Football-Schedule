package com.example.hp.footballmatchschedule.network

import com.example.hp.footballmatchschedule.data.remote.MatchEventResponse
import com.example.hp.footballmatchschedule.data.remote.TeamsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET( "eventspastleague.php")
    fun getLastmatch(@Query( "id") id:String) : Flowable<MatchEventResponse>

    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id:String) : Flowable<MatchEventResponse>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<TeamsResponse>
}