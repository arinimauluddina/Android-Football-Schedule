package com.example.hp.footballmatchschedule.Model

import com.google.gson.annotations.SerializedName

data class TeamsResponse(
    @SerializedName("teams")
    var teams: List<Teams>)