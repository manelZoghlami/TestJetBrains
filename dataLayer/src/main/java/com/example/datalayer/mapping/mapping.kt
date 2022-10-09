package com.example.datalayer.mapping

import com.example.datalayer.api.JetBrainsJson
import com.example.domainlayer.model.JetBrains

internal fun JetBrainsJson.toJetBrains() = JetBrains(
    fullName = fullName ?: "",
    forks = forks?.toString() ?: "",
    openIssues = openIssues?.toString() ?: "",
    watchers = watchers?.toString() ?: "",
    description = description ?: ""
)