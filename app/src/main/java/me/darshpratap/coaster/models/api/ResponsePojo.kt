package me.darshpratap.coaster.models.api

import com.google.gson.annotations.SerializedName

data class ResponsePojo(
        @SerializedName("performance")
        private val performancePojo: PerformancePojo,
        @SerializedName("accessibility")
        private val accessibilityPojo: AccessibilityPojo,
        @SerializedName("best-practices")
        private val bestPracticesPojo: BestPracticesPojo,
        @SerializedName("pwa")
        private val pwaPojo: PwaPojo,
        @SerializedName("seo")
        private val seoPojo: SeoPojo
)