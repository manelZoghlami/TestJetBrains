package com.example.testjetbrains.di

import android.app.Application
import com.example.testjetbrains.di.modules.AppModule

class JetBrainsApp: Application(), AppComponent {
    lateinit var appComponent: AppComponent
    init {
        initDagger()
    }
    private fun initDagger(){
        appComponent = DaggerTestAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
    override fun fragmentsComponent(): FragmentsComponent = appComponent.fragmentsComponent()

}