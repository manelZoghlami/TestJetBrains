package com.example.testjetbrains.di

import androidx.fragment.app.Fragment

val Fragment.injector: FragmentsComponent?
    get() = (context?.applicationContext as? AppComponent)?.fragmentsComponent()
