package me.darshpratap.coaster.models.api

import com.google.gson.annotations.SerializedName

data class ContentPojo(
        @SerializedName("title") val title: String,
        @SerializedName("description") val description: String,
        @SerializedName("displayValue") val displayValue: String,
        @SerializedName("group") val group: String,
        @SerializedName("scoreDisplayMode") val scoreDisplayMode: String,
        @SerializedName("score") val score: Double
)