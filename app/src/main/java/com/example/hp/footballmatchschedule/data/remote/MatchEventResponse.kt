package com.example.hp.footballmatchschedule.data.remote

import com.example.hp.footballmatchschedule.model.MatchEvent
import com.google.gson.annotations.SerializedName

data class MatchEventResponse(
    @SerializedName("events") var events: List<MatchEvent>)
