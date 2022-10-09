package com.example.testjetbrains.di.modules

import com.example.datalayer.api.JetBrainsApi
import com.example.datalayer.repository.JetBrainRepositoryImpl
import com.example.domainlayer.repository.JetBrainsRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoriesModule {
    @Provides
    fun provideJetBrainsRepository(jetBrainsApi: JetBrainsApi): JetBrainsRepository {
        return JetBrainRepositoryImpl(jetBrainsApi)
    }
}