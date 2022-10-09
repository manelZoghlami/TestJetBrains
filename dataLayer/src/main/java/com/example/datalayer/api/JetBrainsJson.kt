package com.example.datalayer.api

import com.google.gson.annotations.SerializedName

data class JetBrainsJson(@SerializedName("full_name") val fullName: String?,
                         @SerializedName("forks") val forks: Int?,
                         @SerializedName("open_issues") val openIssues: Int?,
                         @SerializedName("watchers") val watchers: Int?,
                         @SerializedName("description") val description: String?,
)