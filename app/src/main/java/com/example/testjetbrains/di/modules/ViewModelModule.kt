package com.example.testjetbrains.di.modules

import com.example.domainlayer.useCase.GetListBrainsUseCase
import com.example.testjetbrains.ui.repos.ListViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun provideListViewModel(getListBrainsUseCase: GetListBrainsUseCase): ListViewModel {
        return ListViewModel(getListBrainsUseCase)
    }
}