package me.darshpratap.coaster.models.api

import com.google.gson.annotations.SerializedName

data class AccessibilityPojo(
        @SerializedName("title") val title: String,
        @SerializedName("score") val score: Double,
        @SerializedName("contents") val contentPojo: List<ContentPojo>
)