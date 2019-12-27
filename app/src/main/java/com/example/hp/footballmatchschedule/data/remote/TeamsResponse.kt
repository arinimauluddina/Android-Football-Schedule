package com.example.hp.footballmatchschedule.data.remote

import com.example.hp.footballmatchschedule.model.Teams
import com.google.gson.annotations.SerializedName

data class TeamsResponse(
    @SerializedName("teams")
    var teams: List<Teams>)