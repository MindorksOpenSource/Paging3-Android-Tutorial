package com.mindorks.example.paging3.data.response

import com.mindorks.example.paging.data.response.Ad
import com.squareup.moshi.Json

data class ApiResponse(
    @Json(name = "ad")
    val ad: Ad,
    @Json(name = "data")
    val myData: List<Data>,
    @Json(name = "page")
    val page: Int,
    @Json(name = "per_page")
    val per_page: Int,
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val total_pages: Int
)