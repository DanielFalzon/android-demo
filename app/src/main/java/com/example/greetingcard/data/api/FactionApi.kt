package com.example.greetingcard.data.api

import com.example.greetingcard.data.model.Faction
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FactionApi {

    @GET("Faction")
    suspend fun getFactions(): List<Faction>

    @POST("Faction")
    //suspend = blocking request (called within a co-routine so needs to be explicit)
    suspend fun createFaction(@Body faction: Faction): List<Faction>
}