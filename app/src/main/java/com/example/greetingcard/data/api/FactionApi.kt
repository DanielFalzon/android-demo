package com.example.greetingcard.data.api

import com.example.greetingcard.data.model.Faction
import retrofit2.http.Body
import retrofit2.http.POST

interface FactionApi {

    @POST("Faction")
    //suspend = blocking request (called within a co-routine so needs to be explicit)
    suspend fun createFaction(@Body faction: Faction)
}