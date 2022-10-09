package com.example.datalayer.repository

import com.example.datalayer.api.JetBrainsApi
import com.example.datalayer.mapping.toJetBrains
import com.example.domainlayer.model.JetBrains
import com.example.domainlayer.repository.JetBrainsRepository

class JetBrainRepositoryImpl(private val jetBrainsApi: JetBrainsApi) : JetBrainsRepository {
    override suspend fun getListJetBrains(): List<JetBrains> {
        return jetBrainsApi.getListJetBrain().body()?.map { jetBrainsJson ->
            jetBrainsJson.toJetBrains()
        } ?: emptyList()
    }
}