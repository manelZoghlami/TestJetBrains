package com.example.testjetbrains.di

import com.example.testjetbrains.ui.repos.ListFragment
import dagger.Subcomponent

@Subcomponent
interface FragmentsComponent {
    fun inject(fragment: ListFragment)
}