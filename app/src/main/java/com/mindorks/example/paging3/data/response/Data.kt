package com.mindorks.example.paging3.data.response

import com.squareup.moshi.Json

data class Data(
    @Json(name = "avatar")
    val avatar: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "first_name")
    val firstName: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "last_name")
    val lastName: String
)

