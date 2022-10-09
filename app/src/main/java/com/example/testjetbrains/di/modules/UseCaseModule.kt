package com.example.testjetbrains.di.modules

import com.example.domainlayer.repository.JetBrainsRepository
import com.example.domainlayer.useCase.GetListBrainsUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {
    @Provides
    fun provideGetListBrainsUseCase(jetBrainsRepository: JetBrainsRepository): GetListBrainsUseCase {
        return GetListBrainsUseCase(jetBrainsRepository)
    }


}