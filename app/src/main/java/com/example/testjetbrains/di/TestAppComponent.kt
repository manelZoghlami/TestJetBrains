package com.example.testjetbrains.di

import com.example.testjetbrains.di.AppComponent
import com.example.testjetbrains.di.modules.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UseCaseModule::class,
    RepositoriesModule::class, ViewModelModule::class, NetworkModule::class])
interface TestAppComponent : AppComponent