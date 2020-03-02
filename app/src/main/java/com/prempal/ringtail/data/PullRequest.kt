package com.prempal.ringtail.data

import com.google.gson.annotations.SerializedName


/**
 * Created by prempal on 3/2/20.
 */
data class PullRequest(
    @SerializedName("closed_at")
    val closedAt: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("user")
    val user: User
)

data class User(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("login")
    val login: String
)
