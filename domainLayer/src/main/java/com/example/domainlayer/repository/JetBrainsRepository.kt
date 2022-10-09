package com.example.domainlayer.repository

import com.example.domainlayer.model.JetBrains

interface JetBrainsRepository {
    suspend fun getListJetBrains(): List<JetBrains>
}