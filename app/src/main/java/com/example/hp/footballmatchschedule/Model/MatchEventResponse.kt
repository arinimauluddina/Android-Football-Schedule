package com.example.hp.footballmatchschedule.Model

import com.google.gson.annotations.SerializedName

data class MatchEventResponse(
    @SerializedName("events") var events: List<MatchEvent>)
