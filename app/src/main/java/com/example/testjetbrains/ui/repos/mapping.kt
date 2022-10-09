package com.example.testjetbrains.ui.repos

import com.example.domainlayer.model.JetBrains

internal fun JetBrains.toUi() =  JetBrainsUi(fullName, forks, openIssues, watchers, description)