package com.example.testjetbrains.di.modules

import android.content.Context
import com.example.testjetbrains.di.JetBrainsApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (private val application: JetBrainsApp) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return application
    }
}