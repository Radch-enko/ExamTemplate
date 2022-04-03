package com.api.demoexamen.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ActivityResponse(
    @SerialName("activity")
    val activity: String,
    @SerialName("accessibility")
    val accessibility: Float,
    @SerialName("type")
    val type: String,
    @SerialName("participants")
    val participants: Int,
    @SerialName("price")
    val price: Float,
    @SerialName("link")
    val link: String,
    @SerialName("key")
    val key: String
)