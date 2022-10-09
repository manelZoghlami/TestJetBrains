package com.example.datalayer.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JetBrainsApi {
    @GET("repos?page=1")
    suspend fun getListJetBrain(): Response<List<JetBrainsJson>>
}