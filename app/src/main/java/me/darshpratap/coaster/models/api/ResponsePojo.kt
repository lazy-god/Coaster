package me.darshpratap.coaster.models.api

import com.google.gson.annotations.SerializedName

data class ResponsePojo(
        @SerializedName("performance") val performancePojo: PerformancePojo,
        @SerializedName("accessibility") val accessibilityPojo: AccessibilityPojo,
        @SerializedName("best-practices") val bestPracticesPojo: BestPracticesPojo,
        @SerializedName("pwa") val pwaPojo: PwaPojo,
        @SerializedName("seo") val seoPojo: SeoPojo
)